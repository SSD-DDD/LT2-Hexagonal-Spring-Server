package user.api

import annotation.Api
import user.api.dto.request.DomainSignUpRequest

@Api
interface UserSignUpApi {
    fun userSignUp(request: DomainSignUpRequest)
}