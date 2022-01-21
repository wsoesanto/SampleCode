package com.elfin.atlas.example

import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.options.PipelineOptions
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.FlatMapElements
import org.apache.beam.sdk.transforms.ProcessFunction
import org.apache.beam.sdk.transforms.SerializableFunction
import org.apache.beam.sdk.values.TypeDescriptors
import java.util.*

fun main(args: Array<String>) {
    val options = PipelineOptionsFactory.create()

    val pipeline = Pipeline.create(options)
}