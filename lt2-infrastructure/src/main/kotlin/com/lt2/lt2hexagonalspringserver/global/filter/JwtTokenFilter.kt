package com.lt2.lt2hexagonalspringserver.global.security.jwt

import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties.Companion.HEADER
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtTokenParser: JwtTokenParser
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val bearer = resolveToken(request)

        bearer?.let {
            val token = jwtTokenParser.parseToken(it)
            val authentication = jwtTokenParser.authentication(token)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun resolveToken(request: HttpServletRequest): String? = request.getHeader(HEADER)
}