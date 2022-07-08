package com.lt2.lt2hexagonalspringserver.global.annotation.config

import annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.lt2.lt2hexagonalspringserver"],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [UseCase::class]
        )
    ]
)
class GlobalComponentScan {
}