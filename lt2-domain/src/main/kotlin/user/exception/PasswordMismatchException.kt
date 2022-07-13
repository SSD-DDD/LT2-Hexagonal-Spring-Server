package user.exception

import error.Lt2Exception
import error.code.ErrorMessage.PASSWORD_MISMATCH
import error.code.ErrorStatus.UNAUTHORIZED_401

object PasswordMismatchException: Lt2Exception(
    UNAUTHORIZED_401,
    PASSWORD_MISMATCH
) {
}