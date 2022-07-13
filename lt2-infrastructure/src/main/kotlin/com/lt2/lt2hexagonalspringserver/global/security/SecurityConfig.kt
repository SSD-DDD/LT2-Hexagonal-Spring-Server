package com.lt2.lt2hexagonalspringserver.global.security

import com.lt2.lt2hexagonalspringserver.global.filter.FilterConfig
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtTokenParser
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenParser: JwtTokenParser
) {

    @Bean
    fun securityFilterConfig(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity
            .csrf().disable()
            .cors()

            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .antMatchers("*").permitAll()

            .and()
            .apply(FilterConfig(jwtTokenParser))

        return httpSecurity.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}