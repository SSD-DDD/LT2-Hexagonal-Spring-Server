package com.lt2.lt2hexagonalspringserver.global.error

import error.ExceptionAttribute

data class ErrorResponse(
    override val status: Int,
    override val message: String
): ExceptionAttribute {
}