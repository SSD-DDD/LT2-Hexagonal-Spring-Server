package auth.exception

import auth.exception.message.RefreshTokenErrorMessage.REFRESH_TOKEN_NOT_FOUND
import error.Lt2Exception
import error.code.GlobalErrorStatus.NOT_FOUND_404

object RefreshTokenNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    REFRESH_TOKEN_NOT_FOUND
) {
}