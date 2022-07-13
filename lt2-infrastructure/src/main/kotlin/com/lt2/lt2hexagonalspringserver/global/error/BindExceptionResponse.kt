package com.lt2.lt2hexagonalspringserver.global.error

class BindExceptionResponse(
    val status: Int,
    val errorField: Map<String, String?>
)