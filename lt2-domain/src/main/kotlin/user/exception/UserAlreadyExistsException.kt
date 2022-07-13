package user.exception

import error.Lt2Exception
import error.code.GlobalErrorStatus.CONFLICT_409
import user.exception.message.UserErrorMessage.USER_ALREADY_EXISTS

object UserAlreadyExistsException: Lt2Exception(
    CONFLICT_409,
    USER_ALREADY_EXISTS
) {
}