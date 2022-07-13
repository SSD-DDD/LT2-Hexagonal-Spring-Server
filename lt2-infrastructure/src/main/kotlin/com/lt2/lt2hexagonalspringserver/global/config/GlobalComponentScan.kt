package com.lt2.lt2hexagonalspringserver.global.config

import annotation.DomainService
import auth.RefreshToken
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import user.User

@Configuration
@ComponentScan(
    basePackageClasses = [User::class, RefreshToken::class],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [DomainService::class]
        )
    ]
)
class GlobalComponentScan {
}