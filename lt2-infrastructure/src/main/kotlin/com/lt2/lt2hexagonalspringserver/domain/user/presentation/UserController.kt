package com.lt2.lt2hexagonalspringserver.domain.user.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import user.api.CreateUserApi
import user.api.dto.request.CreateUserDomainRequest

@RequestMapping("/users")
@RestController
class UserController(
    private val createUserApi: CreateUserApi
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun userSignUp(@RequestBody request: CreateUserDomainRequest) {
        createUserApi.saveUser(request)
    }
}