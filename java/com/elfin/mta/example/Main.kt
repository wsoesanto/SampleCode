@file:JvmName("Main")
@file:JvmMultifileClass

package com.elfin.mta.example

import com.google.transit.realtime.GtfsRealtime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

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
  val client = OkHttpClient()
  val request =
    Request.Builder()
      .url("https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-nqrw")
      .addHeader("x-api-key", "E5WFtyBrAM6b5QvDmstyW2B4neUJNFzs6ZlVBBv4")
      .get()
      .build()

  val response = client.newCall(request).asyncExecute()
  println(response.body!!.use {
    withContext(Dispatchers.IO) {
      GtfsRealtime.FeedMessage.parseFrom(it.bytes())
    }
  })
}