package domain.user.api

import domain.user.api.dto.request.DomainSignUpRequest

interface UserSignUpPort {
    fun userSignUp(request: DomainSignUpRequest)
}