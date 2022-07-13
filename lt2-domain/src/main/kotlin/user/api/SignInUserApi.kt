package user.api

import user.api.dto.request.SignInUserDomainRequest

interface SignInUserApi {
    fun signInUser(request: SignInUserDomainRequest)
}