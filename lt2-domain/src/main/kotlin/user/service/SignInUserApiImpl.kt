package user.service

import annotation.DomainService
import user.api.SignInUserApi
import user.api.dto.request.SignInUserDomainRequest
import user.exception.PasswordMismatchException
import user.spi.UserRepositorySpi

@DomainService
class SignInUserApiImpl(
    private val userRepositorySpi: UserRepositorySpi
): SignInUserApi {

    override fun signInUser(request: SignInUserDomainRequest) {
        val user = userRepositorySpi.findByAccountId(request.accountId)

        if (!userRepositorySpi.passwordMatch(user.password, request.password)) throw PasswordMismatchException
    }
}