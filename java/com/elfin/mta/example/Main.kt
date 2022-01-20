@file:JvmName("Main")
@file:JvmMultifileClass

package com.elfin.mta.example

import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableMap.toImmutableMap
import com.google.devtools.build.runfiles.Runfiles
import com.google.protobuf.ExtensionRegistry
import com.google.transit.realtime.GtfsRealtime
import com.google.transit.realtime.NyctSubway
import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvToBeanBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.FileHandle
import java.io.FileReader
import java.io.IOException
import java.io.Reader
import java.util.function.Function.identity
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

data class Entry(
  @CsvBindByName(column = "Station ID")
  val stationId: String? = null,
  @CsvBindByName(column = "Complex ID")
  val complexId: String? = null,
  @CsvBindByName(column = "GTFS Stop ID")
  val gtfsStopId: String? = null,
  @CsvBindByName(column = "Division")
  val division: String? = null,
  @CsvBindByName(column = "Line")
  val line: String? = null,
  @CsvBindByName(column = "Stop Name")
  val stopName: String? = null,
  @CsvBindByName(column = "Borough")
  val borough: String? = null,
  @CsvBindByName(column = "Daytime Routes")
  val daytimeRoutes: String? = null,
  @CsvBindByName(column = "Structure")
  val structure: String? = null,
  @CsvBindByName(column = "GTFS Latitude")
  val gtfsLatitude: Double? = null,
  @CsvBindByName(column = "GTFS Longitude")
  val gtfsLongitude: Double? = null,
  @CsvBindByName(column = "North Direction Label")
  val northDirectionLabel: String? = null,
  @CsvBindByName(column = "South Direction Label")
  val southDirectionLabel: String? = null,
  @CsvBindByName(column = "ADA")
  val ada: String? = null,
  @CsvBindByName(column = "ADA Notes")
  val adaNotes: String? = null) {
}

suspend fun Call.asyncExecute(): Response = suspendCoroutine { cont ->
  enqueue(object : Callback {
    override fun onFailure(call: Call, e: IOException) {
      cont.resumeWithException(e)
    }

    override fun onResponse(call: Call, response: Response) {
      cont.resume(response)
    }
  })
}

fun main(args: Array<String>) = runBlocking {
  val extensionRegistry = ExtensionRegistry.newInstance()
  extensionRegistry.add(NyctSubway.nyctFeedHeader)
  extensionRegistry.add(NyctSubway.nyctTripDescriptor)
  extensionRegistry.add(NyctSubway.nyctStopTimeUpdate)

  val client = OkHttpClient()
  val request =
    Request.Builder()
      .url("https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-g")
      .addHeader("x-api-key", "E5WFtyBrAM6b5QvDmstyW2B4neUJNFzs6ZlVBBv4")
      .get()
      .build()

  val response = client.newCall(request).asyncExecute()
  val feedMessage = response.body!!.use {
    withContext(Dispatchers.IO) {
      GtfsRealtime.FeedMessage.parseFrom(it.bytes(), extensionRegistry)
    }
  }

  val entries = withContext(Dispatchers.IO) {
    CsvToBeanBuilder<Entry>(FileReader("java/com/elfin/mta/Stations.csv")).withType(Entry::class.java)
      .build().stream()
  }
  val dict = entries.collect(toImmutableMap(Entry::gtfsStopId, identity()))

  for (entity in feedMessage.entityList) {
    for (stopTimeUpdate in entity.tripUpdate.stopTimeUpdateList) {
      println(dict[stopTimeUpdate.stopId])
    }
  }
}