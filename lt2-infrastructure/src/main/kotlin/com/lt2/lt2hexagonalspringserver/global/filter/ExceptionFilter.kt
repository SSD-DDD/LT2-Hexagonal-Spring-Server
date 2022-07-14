package com.lt2.lt2hexagonalspringserver.global.filter

import com.lt2.lt2hexagonalspringserver.global.error.ErrorResponse
import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorMessage.INTERNAL_SERVER_ERROR
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.INTERNAL_SERVER_ERROR_500
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Lt2Exception) {
            errorToJson(e.status, e.message, response)
        } catch (e: Exception) {
            if (e.cause is Lt2Exception) {
                val errorStatus = (e.cause as Lt2Exception).status
                val errorMessage = (e.cause as Lt2Exception).message
                errorToJson(errorStatus, errorMessage, response)
            } else {
                errorToJson(INTERNAL_SERVER_ERROR_500, INTERNAL_SERVER_ERROR, response)
                logger.error(e.message)
            }
        }
    }

    private fun errorToJson(status: Int, message: String, response: HttpServletResponse) {
        response.status = status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(ErrorResponse(status, message).toString())
    }
}