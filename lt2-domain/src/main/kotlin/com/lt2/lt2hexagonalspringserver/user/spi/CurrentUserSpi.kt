package user.spi

import java.util.*

interface CurrentUserSpi {
    fun currentUserId(): UUID
}