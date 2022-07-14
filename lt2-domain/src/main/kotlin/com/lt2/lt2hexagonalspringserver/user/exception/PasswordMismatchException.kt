package com.lt2.lt2hexagonalspringserver.user.exception

import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.UNAUTHORIZED_401
import com.lt2.lt2hexagonalspringserver.user.exception.message.UserErrorMessage.PASSWORD_MISMATCH

object PasswordMismatchException: Lt2Exception(
    UNAUTHORIZED_401,
    PASSWORD_MISMATCH
) {
}