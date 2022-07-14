package error.exception

import error.Lt2Exception
import error.code.GlobalErrorMessage.INTERNAL_SERVER_ERROR
import error.code.GlobalErrorStatus.INTERNAL_SERVER_ERROR_500

object InternalServerErrorException: Lt2Exception(
    INTERNAL_SERVER_ERROR_500,
    INTERNAL_SERVER_ERROR
) {
}