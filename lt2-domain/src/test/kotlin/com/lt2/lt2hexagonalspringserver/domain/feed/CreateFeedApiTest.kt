package com.lt2.lt2hexagonalspringserver.domain.feed

import com.lt2.lt2hexagonalspringserver.feed.api.CreateFeedApi
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.CreateFeedDomainRequest
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test

class CreateFeedApiTest {

    private val request = mock<CreateFeedDomainRequest>()

    private val createFeedApi = mock<CreateFeedApi>()

    @Test
    fun execute() {

        given(request.title)
            .willReturn("제목")

        given(request.content)
            .willReturn("내용")

        createFeedApi.execute(request)
    }
}