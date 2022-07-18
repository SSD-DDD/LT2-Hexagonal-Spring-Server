package com.lt2.lt2hexagonalspringserver.user.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.user.User
import com.lt2.lt2hexagonalspringserver.user.api.CreateUserApi
import com.lt2.lt2hexagonalspringserver.user.api.dto.request.CreateUserDomainRequest
import com.lt2.lt2hexagonalspringserver.user.spi.SecurityPasswordSpi
import com.lt2.lt2hexagonalspringserver.user.spi.QueryUserSpi
import com.lt2.lt2hexagonalspringserver.user.type.Role
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

    private fun CreateUserDomainRequest.toUser() =
        User(
            userId = UUID(0, 0),
            accountId = accountId,
            password = securityPasswordSpi.passwordEncode(password),
            name = name,
            money = moneyGenerate(),
            role = Role.USER
        )

    private fun moneyGenerate() = (Math.random() * 100000 + 1 - 50000).toLong() + 50000
}