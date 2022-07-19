package com.lt2.lt2hexagonalspringserver.domain.comment.presentation

import com.lt2.lt2hexagonalspringserver.comment.api.CreateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.UpdateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.CreateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.domain.comment.presentation.dto.request.UpdateCommentWebRequest
import com.lt2.lt2hexagonalspringserver.domain.comment.presentation.dto.request.CreateCommentWebRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/comments")
@RestController
class CommentController(
    private val createCommentApi: CreateCommentApi,
    private val updateCommentApi: UpdateCommentApi
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    fun createComment(@PathVariable(name = "feed-id") feedId: UUID,
                      @RequestBody @Valid request: CreateCommentWebRequest) {
        val commentDomainRequest = CreateCommentDomainRequest(
            content = request.content
        )

        createCommentApi.execute(feedId, commentDomainRequest)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    fun updateComment(@PathVariable(name = "feed-id") feedId: UUID,
                      @RequestBody @Valid request: UpdateCommentWebRequest) {
        val commentDomainRequest = UpdateCommentDomainRequest(
            content = request.content
        )

        updateCommentApi.execute(feedId, commentDomainRequest)
    }
}