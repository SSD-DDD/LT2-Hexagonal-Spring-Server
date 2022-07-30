package com.lt2.lt2hexagonalspringserver.domain.auth.presentation

import com.lt2.lt2hexagonalspringserver.auth.api.UpdateRefreshTokenApi
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.lt2.lt2hexagonalspringserver.user.api.dto.response.TokenDomainResponse

@RequestMapping("/users")
@RestController
class AuthController(
    private val updateRefreshTokenApi: UpdateRefreshTokenApi
) {

    @PutMapping("/token")
    fun updateRefreshToken(@RequestHeader(name = "refresh-token") token: String): TokenDomainResponse {
        return updateRefreshTokenApi.execute(token)
    }
}