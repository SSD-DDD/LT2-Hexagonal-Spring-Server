package com.lt2.lt2hexagonalspringserver.global.config

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.lt2.lt2hexagonalspringserver"],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [DomainService::class]
        )
    ]
)
class GlobalComponentScan {
}