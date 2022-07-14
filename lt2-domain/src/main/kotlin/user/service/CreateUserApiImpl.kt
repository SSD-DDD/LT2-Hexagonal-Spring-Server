package user.service

import annotation.DomainService
import user.User
import user.api.CreateUserApi
import user.api.dto.request.CreateUserDomainRequest
import user.spi.SecurityPasswordSpi
import user.spi.QueryUserSpi
import user.type.Role
import java.util.*

@DomainService
class CreateUserApiImpl(
    private val queryUserSpi: QueryUserSpi,
    private val securityPasswordSpi: SecurityPasswordSpi
): CreateUserApi {

    override fun execute(request: CreateUserDomainRequest) {
        queryUserSpi.checkUserExistsByAccountId(request.accountId)

        queryUserSpi.saveUser(request.toUser())
    }

    private fun CreateUserDomainRequest.toUser() = User(
        id = UUID(0, 0),
        accountId = accountId,
        password = securityPasswordSpi.passwordEncode(password),
        name = name,
        money = moneyGenerate(),
        role = Role.USER
    )

    private fun moneyGenerate() = (Math.random() * 100000 + 1 - 50000).toLong() + 50000
}