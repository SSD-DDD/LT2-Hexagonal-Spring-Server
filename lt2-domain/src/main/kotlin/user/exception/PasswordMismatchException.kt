package user.exception

import error.Lt2Exception
import error.code.GlobalErrorStatus.UNAUTHORIZED_401
import user.exception.message.UserErrorMessage.PASSWORD_MISMATCH

object PasswordMismatchException: Lt2Exception(
    UNAUTHORIZED_401,
    PASSWORD_MISMATCH
) {
}