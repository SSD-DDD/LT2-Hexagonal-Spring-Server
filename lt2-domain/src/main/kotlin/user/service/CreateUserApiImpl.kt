package user.service

import annotation.DomainService
import user.User
import user.api.CreateUserApi
import user.api.dto.request.CreateUserDomainRequest
import user.spi.UserSecuritySpi
import user.spi.UserRepositorySpi
import java.util.*

@DomainService
class CreateUserApiImpl(
    private val userRepositorySpi: UserRepositorySpi,
    private val userPasswordSpi: UserSecuritySpi
): CreateUserApi {

    override fun saveUser(request: CreateUserDomainRequest) {
        userRepositorySpi.checkUserExistsByAccountId(request.accountId)

        userRepositorySpi.saveUser(request.toUser())
    }

    private fun CreateUserDomainRequest.toUser() = User(
        id = UUID(0, 0),
        accountId = accountId,
        password = userPasswordSpi.passwordEncode(password),
        name = name,
        money = moneyGenerate()
    )

    private fun moneyGenerate() = (Math.random() * 100000 + 1 - 50000).toLong() + 50000
}