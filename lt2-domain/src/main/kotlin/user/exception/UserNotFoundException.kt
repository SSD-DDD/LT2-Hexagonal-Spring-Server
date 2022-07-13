package user.exception

import error.Lt2Exception
import error.code.GlobalErrorStatus.NOT_FOUND_404
import user.exception.message.UserErrorMessage.USER_NOT_FOUND

object UserNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    USER_NOT_FOUND
) {
}