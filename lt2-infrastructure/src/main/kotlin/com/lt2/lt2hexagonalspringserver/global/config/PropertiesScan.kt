package com.lt2.lt2hexagonalspringserver.global.config

import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [JwtProperties::class]
)
@Configuration
class PropertiesScan {
}