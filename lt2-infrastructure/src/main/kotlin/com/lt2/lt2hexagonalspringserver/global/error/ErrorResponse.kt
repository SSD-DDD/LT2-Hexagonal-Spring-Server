package com.lt2.lt2hexagonalspringserver.global.error

import com.lt2.lt2hexagonalspringserver.error.ExceptionAttribute

data class ErrorResponse(
    override val status: Int,
    override val message: String
) : ExceptionAttribute {

    override fun toString() =
        "{\n\t\"status\": $status,\n\t\"message\": \"$message\"\n}"
}