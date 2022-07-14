package com.lt2.lt2hexagonalspringserver.domain.user.presentation

import com.lt2.lt2hexagonalspringserver.domain.user.presentation.dto.request.CreateUserWebRequest
import com.lt2.lt2hexagonalspringserver.domain.user.presentation.dto.request.SignInUserWebRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import user.api.CreateUserApi
import user.api.SignInUserApi
import user.api.dto.request.CreateUserDomainRequest
import user.api.dto.request.SignInUserDomainRequest
import user.api.dto.response.TokenDomainResponse
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val createUserApi: CreateUserApi,
    private val signInUserApi: SignInUserApi
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun userSignUp(@RequestBody @Valid request: CreateUserWebRequest) {
        val domainRequest = CreateUserDomainRequest(
            accountId = request.accountId,
            password = request.password,
            name = request.name
        )

        createUserApi.execute(domainRequest)
    }

    @PostMapping("/token")
    fun userSignIn(@RequestBody @Valid request: SignInUserWebRequest): TokenDomainResponse {
        val domainRequest = SignInUserDomainRequest(
            accountId = request.accountId,
            password = request.password
        )

        return signInUserApi.execute(domainRequest)
    }
}