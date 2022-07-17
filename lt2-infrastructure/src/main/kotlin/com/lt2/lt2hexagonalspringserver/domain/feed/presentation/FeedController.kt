package com.lt2.lt2hexagonalspringserver.domain.feed.presentation

import com.lt2.lt2hexagonalspringserver.domain.feed.presentation.dto.request.CreateFeedWebRequest
import com.lt2.lt2hexagonalspringserver.feed.api.CreateFeedApi
import com.lt2.lt2hexagonalspringserver.feed.api.QueryFeedListApi
import com.lt2.lt2hexagonalspringserver.feed.api.UpdateFeedApi
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.CreateFeedDomainRequest
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.UpdateFeedDomainRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedApi: CreateFeedApi,
    private val queryFeedListApi: QueryFeedListApi,
    private val updateFeedApi: UpdateFeedApi
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedWebRequest) {
        val feedDomainRequest = CreateFeedDomainRequest(
            title = request.title,
            content = request.content
        )

        createFeedApi.execute(feedDomainRequest)
    }

    @GetMapping("/list")
    fun queryFeedList(@RequestParam page: Int) = queryFeedListApi.execute(page)

    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable(name = "feed-id") feedId: UUID,
                   @RequestBody request: UpdateFeedDomainRequest) {
        val feedDomainRequest = UpdateFeedDomainRequest(
            title = request.title,
            content = request.content
        )

        updateFeedApi.execute(feedId, feedDomainRequest)
    }
}