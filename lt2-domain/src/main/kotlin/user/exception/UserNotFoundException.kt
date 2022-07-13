package com.lt2.lt2hexagonalspringserver.domain.user.exception

import com.lt2.lt2hexagonalspringserver.domain.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.domain.user.ErrorMessage
import com.lt2.lt2hexagonalspringserver.domain.user.ErrorStatus

object UserNotFoundException: Lt2Exception(
    ErrorStatus.USER_NOT_FOUND, ErrorMessage.USER_NOT_FOUND
) {
    const val EXCEPTION = ErrorMessage.USER_NOT_FOUND
}