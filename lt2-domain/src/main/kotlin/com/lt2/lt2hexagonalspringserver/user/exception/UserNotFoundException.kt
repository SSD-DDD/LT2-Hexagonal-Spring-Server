package com.lt2.lt2hexagonalspringserver.user.exception

import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.NOT_FOUND_404
import com.lt2.lt2hexagonalspringserver.user.exception.message.UserErrorMessage.USER_NOT_FOUND

object UserNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    USER_NOT_FOUND
) {
}