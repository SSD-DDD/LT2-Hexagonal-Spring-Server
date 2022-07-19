package com.lt2.lt2hexagonalspringserver.comment.exception

import com.lt2.lt2hexagonalspringserver.comment.exception.message.CommentErrorMessage.COMMENT_NOT_FOUND
import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.NOT_FOUND_404

object CommentNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    COMMENT_NOT_FOUND
) {
}