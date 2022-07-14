package com.lt2.lt2hexagonalspringserver.user.api

import com.lt2.lt2hexagonalspringserver.user.api.dto.request.CreateUserDomainRequest

interface CreateUserApi {
    fun execute(request: CreateUserDomainRequest)
}