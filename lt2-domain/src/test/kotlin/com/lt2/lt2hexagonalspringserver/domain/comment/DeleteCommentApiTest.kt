package com.lt2.lt2hexagonalspringserver.domain.comment

import com.lt2.lt2hexagonalspringserver.comment.api.DeleteCommentApi
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import java.util.UUID

class DeleteCommentApiTest {

    private val deleteCommentApi = mock<DeleteCommentApi>()

    private val uuid = mock<UUID>()

    @Test
    fun execute() {
        deleteCommentApi.execute(uuid)
    }
}