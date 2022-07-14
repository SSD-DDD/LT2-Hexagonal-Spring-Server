package com.lt2.lt2hexagonalspringserver.user.exception

import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.CONFLICT_409
import com.lt2.lt2hexagonalspringserver.user.exception.message.UserErrorMessage.USER_ALREADY_EXISTS

object UserAlreadyExistsException: Lt2Exception(
    CONFLICT_409,
    USER_ALREADY_EXISTS
) {
}