package user.api

import user.api.dto.request.CreateUserDomainRequest

interface CreateUserApi {
    fun saveUser(request: CreateUserDomainRequest)
}