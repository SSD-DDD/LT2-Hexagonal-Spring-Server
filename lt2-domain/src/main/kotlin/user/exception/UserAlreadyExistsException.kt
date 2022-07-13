package user.exception

import error.Lt2Exception
import error.code.ErrorMessage.USER_NOT_FOUND
import error.code.ErrorStatus.CONFLICT_409

object UserAlreadyExistsException: Lt2Exception(
    CONFLICT_409,
    USER_NOT_FOUND
) {
}