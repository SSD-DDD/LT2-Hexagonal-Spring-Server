package user.exception

import error.Lt2Exception
import error.code.ErrorMessage.USER_NOT_FOUND
import error.code.ErrorStatus.NOT_FOUND_404

object UserNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    USER_NOT_FOUND
) {
}