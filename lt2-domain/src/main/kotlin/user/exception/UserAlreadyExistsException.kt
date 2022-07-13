package user.exception

import error.code.ErrorMessage
import error.code.ErrorStatus
import error.Lt2Exception

object UserAlreadyExistsException: Lt2Exception(
    ErrorStatus.USER_ALREADY_EXISTS,
    ErrorMessage.USER_ALREADY_EXISTS
) {
}