package com.lt2.lt2hexagonalspringserver.error

abstract class Lt2Exception(
    override val status: Int,
    override val message: String
): RuntimeException(), ExceptionAttribute {
    override fun fillInStackTrace(): Throwable {
        return this
    }
}