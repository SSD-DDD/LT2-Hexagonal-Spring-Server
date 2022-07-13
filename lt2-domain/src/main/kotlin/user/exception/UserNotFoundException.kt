package user.exception

import error.code.ErrorMessage
import error.code.ErrorStatus
import error.Lt2Exception

object UserNotFoundException: Lt2Exception(
    ErrorStatus.USER_NOT_FOUND,
    ErrorMessage.USER_NOT_FOUND
) {
}