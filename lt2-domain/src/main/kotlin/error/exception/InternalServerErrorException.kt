package error.exception

import error.Lt2Exception
import error.code.ErrorMessage
import error.code.ErrorStatus

object InternalServerException: Lt2Exception(
    ErrorStatus.INTERNAL_SERVER,
    ErrorMessage.INTERNAL_SERVER
) {
}