package user.spi

interface CurrentUserSpi {
    fun currentUser(): String
}