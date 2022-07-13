package com.lt2.lt2hexagonalspringserver.global.security.jwt.exception

import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.message.JwtErrorMessage.INVALID_JWT
import error.Lt2Exception
import error.code.GlobalErrorStatus.UNAUTHORIZED_401

object InvalidJwtException: Lt2Exception(
    UNAUTHORIZED_401,
    INVALID_JWT
) {
}