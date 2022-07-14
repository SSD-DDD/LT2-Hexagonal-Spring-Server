package com.lt2.lt2hexagonalspringserver.domain.feed.presentation

import com.lt2.lt2hexagonalspringserver.domain.feed.presentation.dto.request.CreateFeedWebRequest
import com.lt2.lt2hexagonalspringserver.feed.api.CreateFeedApi
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.CreateFeedDomainRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedApi: CreateFeedApi
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedWebRequest) {
        val feedDomain = CreateFeedDomainRequest(
            title = request.title,
            content = request.content
        )
        createFeedApi.execute(feedDomain)
    }
}