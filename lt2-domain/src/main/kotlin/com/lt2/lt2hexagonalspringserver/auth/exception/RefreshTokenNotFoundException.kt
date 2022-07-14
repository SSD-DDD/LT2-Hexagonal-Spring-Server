package com.lt2.lt2hexagonalspringserver.auth.exception

import com.lt2.lt2hexagonalspringserver.auth.exception.message.RefreshTokenErrorMessage.REFRESH_TOKEN_NOT_FOUND
import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.NOT_FOUND_404

object RefreshTokenNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    REFRESH_TOKEN_NOT_FOUND
) {
}