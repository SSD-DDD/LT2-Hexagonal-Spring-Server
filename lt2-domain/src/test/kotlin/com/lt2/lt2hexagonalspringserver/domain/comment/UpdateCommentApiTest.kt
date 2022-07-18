package com.lt2.lt2hexagonalspringserver.domain.comment

import com.lt2.lt2hexagonalspringserver.comment.api.UpdateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import java.util.UUID

class UpdateCommentApiTest {

    private val uuid = mock<UUID>()

    private val request = mock<UpdateCommentDomainRequest>()

    private val updateCommentApi = mock<UpdateCommentApi>()

    @Test
    fun execute() {

        given(request.content)
            .willReturn("댓글 수정")

        updateCommentApi.execute(uuid, request)
    }
}