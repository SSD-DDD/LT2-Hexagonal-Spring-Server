package user.spi

import annotation.Spi
import user.User

@Spi
interface UserRepositorySpi {
    fun saveUser(user: User)
    fun checkUserExistsByAccountId(accountId: String)
    fun findByAccountId(accountId: String): User
    fun passwordEncode(password: String): String
    fun passwordMatch(rawPassword: String, encodedPassword: String): Boolean
}
