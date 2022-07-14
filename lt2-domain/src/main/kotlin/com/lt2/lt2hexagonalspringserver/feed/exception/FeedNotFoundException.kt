package com.lt2.lt2hexagonalspringserver.feed.exception

import com.lt2.lt2hexagonalspringserver.error.Lt2Exception
import com.lt2.lt2hexagonalspringserver.error.code.GlobalErrorStatus.NOT_FOUND_404
import com.lt2.lt2hexagonalspringserver.feed.exception.message.FeedErrorMessage.FEED_NOT_FOUND

object FeedNotFoundException: Lt2Exception(
    NOT_FOUND_404,
    FEED_NOT_FOUND
) {
}