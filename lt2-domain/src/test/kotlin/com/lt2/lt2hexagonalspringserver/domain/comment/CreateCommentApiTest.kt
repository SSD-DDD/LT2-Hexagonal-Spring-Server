package com.lt2.lt2hexagonalspringserver.domain.comment

import com.lt2.lt2hexagonalspringserver.comment.api.CreateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.CreateCommentDomainRequest
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import java.util.UUID

class CreateCommentApiTest {

    private val request = mock<CreateCommentDomainRequest>()

    private val createCommentApi = mock<CreateCommentApi>()

    @Test
    fun execute() {

        val feedId = UUID(0, 0)

        given(request.content)
            .willReturn("댓글")

        given(feedId)
            .willReturn(UUID.randomUUID())

        createCommentApi.execute(feedId, request)
    }
}