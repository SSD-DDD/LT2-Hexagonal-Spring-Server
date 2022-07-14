package user.api

import user.api.dto.request.CreateUserDomainRequest

interface CreateUserApi {
    fun execute(request: CreateUserDomainRequest)
}