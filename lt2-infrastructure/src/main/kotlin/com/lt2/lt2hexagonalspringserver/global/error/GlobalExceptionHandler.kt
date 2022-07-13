package com.lt2.lt2hexagonalspringserver.global.error

import error.Lt2Exception
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Lt2Exception::class)
    fun errorHandle(e: Lt2Exception): ResponseEntity<ErrorResponse> {
        val errorStatus = e.status
        val errorMessage = e.message

        return ResponseEntity(
            ErrorResponse(errorStatus, errorMessage),
            HttpStatus.valueOf(errorStatus)
        )
    }
}