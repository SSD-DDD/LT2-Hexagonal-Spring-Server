package com.lt2.lt2hexagonalspringserver.global.security.jwt.exception

import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.message.JwtErrorMessage.JWT_EXPIRED
import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.UNAUTHORIZED_401

object JwtExpiredException: Lt2Exception(
    UNAUTHORIZED_401,
    JWT_EXPIRED
) {
}