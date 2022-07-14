package com.lt2.lt2hexagonalspringserver.error.exception

import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorMessage.INTERNAL_SERVER_ERROR
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.INTERNAL_SERVER_ERROR_500

object InternalServerErrorException: Lt2Exception(
    INTERNAL_SERVER_ERROR_500,
    INTERNAL_SERVER_ERROR
) {
}