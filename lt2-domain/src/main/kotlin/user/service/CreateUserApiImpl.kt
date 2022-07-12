package user.service

import annotation.DomainService
import user.User
import user.api.CreateUserApi
import user.api.dto.request.CreateUserDomainRequest
import user.spi.UserRepositorySpi

@DomainService
class CreateUserApiImpl(
    private val userRepositorySpi: UserRepositorySpi
): CreateUserApi {

    override fun saveUser(request: CreateUserDomainRequest) {
        val user = userRepositorySpi.findByAccountId(request.accountId)

        userRepositorySpi.saveUser(user.toUser(request))
    }

    private fun User.toUser(request: CreateUserDomainRequest) = User(
        id = id,
        accountId = request.accountId,
        password = userRepositorySpi.passwordEncode(request.password),
        name = request.name,
        money = moneyGenerate()
    )

    private fun moneyGenerate() = (Math.random() * 10000 + 1 - 5000).toLong() + 5000
}