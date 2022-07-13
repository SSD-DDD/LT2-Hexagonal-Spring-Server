package error.exception

import error.Lt2Exception
import error.code.ErrorMessage.INTERNAL_SERVER_ERROR
import error.code.ErrorStatus.INTERNAL_SERVER_ERROR_500

object InternalServerErrorException: Lt2Exception(
    INTERNAL_SERVER_ERROR_500,
    INTERNAL_SERVER_ERROR
) {
}