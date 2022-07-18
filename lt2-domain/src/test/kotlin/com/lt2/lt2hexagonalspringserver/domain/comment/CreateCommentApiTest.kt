package com.lt2.lt2hexagonalspringserver.domain.comment

import com.lt2.lt2hexagonalspringserver.comment.api.CreateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.CreateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.feed.exception.FeedNotFoundException
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.`when`
import java.util.UUID

class CreateCommentApiTest {

    private val request = mock<CreateCommentDomainRequest>()

    private val createCommentApi = mock<CreateCommentApi>()

    private val uuid = mock<UUID>()

    @Test
    fun execute() {

        given(request.content)
            .willReturn("댓글")

        createCommentApi.execute(uuid, request)
    }

}