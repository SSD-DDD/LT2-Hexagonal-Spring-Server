package com.lt2.lt2hexagonalspringserver.global.error

import error.Lt2Exception
import error.code.ErrorStatus.BAD_REQUEST_400
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
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

    @ExceptionHandler(BindException::class)
    fun bindException(e: BindException): ResponseEntity<BindExceptionResponse> {
        val errorMap = HashMap<String, String?>()

        for (error: FieldError in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }

        return ResponseEntity(
            BindExceptionResponse(BAD_REQUEST_400, errorMap),
            HttpStatus.valueOf(BAD_REQUEST_400)
        )
    }
}