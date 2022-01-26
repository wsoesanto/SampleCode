package com.elfin.atlas

import dagger.hilt.GeneratesRootInput


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@GeneratesRootInput
annotation class GrpcServer