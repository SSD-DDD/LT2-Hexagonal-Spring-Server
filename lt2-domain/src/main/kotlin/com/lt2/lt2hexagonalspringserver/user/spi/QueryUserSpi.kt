package user.spi

import annotation.Spi
import user.User

@Spi
interface QueryUserSpi {
    fun saveUser(user: User)
    fun checkUserExistsByAccountId(accountId: String)
    fun findByAccountId(accountId: String): User
}
