package com.lt2.lt2hexagonalspringserver.domain.comment.presentation

import com.lt2.lt2hexagonalspringserver.comment.api.CreateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.CreateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.domain.comment.presentation.dto.request.CreateCommentWebRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/comments")
@RestController
class CommentController(
    private val createCommentApi: CreateCommentApi
) {

    @PostMapping("/{feed-id}")
    fun createComment(@PathVariable(name = "feed-id") feedId: UUID,
                      @RequestBody @Valid request: CreateCommentWebRequest) {
        val commentDomainRequest = CreateCommentDomainRequest(
            content = request.content
        )

        createCommentApi.execute(feedId, commentDomainRequest)
    }
}