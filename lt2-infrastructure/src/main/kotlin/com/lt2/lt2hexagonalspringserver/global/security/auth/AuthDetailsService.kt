package com.lt2.lt2hexagonalspringserver.global.security.auth

import com.lt2.lt2hexagonalspringserver.domain.user.domain.repository.UserPersistenceAdapter
import com.lt2.lt2hexagonalspringserver.domain.user.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userPersistenceAdapter: UserPersistenceAdapter
): UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userPersistenceAdapter.jpaUserByAccountId(accountId)

        return AuthDetails(user)
    }
}