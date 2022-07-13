package com.lt2.lt2hexagonalspringserver.global.security

import com.lt2.lt2hexagonalspringserver.global.filter.ExceptionFilter
import com.lt2.lt2hexagonalspringserver.global.filter.JwtTokenFilter
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtTokenParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtTokenParser: JwtTokenParser
): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val jwtTokenFilter = JwtTokenFilter(jwtTokenParser)
        val exceptionFilter = ExceptionFilter()
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, JwtTokenFilter::class.java)
    }
}