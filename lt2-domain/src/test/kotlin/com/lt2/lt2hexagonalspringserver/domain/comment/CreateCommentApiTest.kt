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

    private val uuid = mock<UUID>()

    @Test
    fun execute() {

        given(request.content)
            .willReturn("댓글")

        createCommentApi.execute(uuid, request)
    }

}