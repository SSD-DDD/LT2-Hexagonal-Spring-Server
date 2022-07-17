object Dependencies {

    //kotlin spring
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    //spring starter
    const val SPRING_STARTER = "org.springframework.boot:spring-boot-starter-web"
    const val SPRING_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    //database
    const val MYSQL_CONNECTOR = "mysql:mysql-connector-java"
    const val JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    //jwt token
    const val JWT = "io.jsonwebtoken:jjwt:${DependencyVersions.JWT_VERSION}"

    //logging
    const val KOTLIN_LOGGING = "io.github.microutils:kotlin-logging-jvm:${DependencyVersions.KOTLIN_LOGGING_VERSION}"

    //test
    const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test:${PluginVersions.SPRING_BOOT_VERSION}"
    const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${DependencyVersions.MOCKITO_VERSION}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${DependencyVersions.MOCKITO_INLINE_VERSION}"

    //querydsl
    const val QUERYDSL = "com.querydsl:querydsl-jpa:${DependencyVersions.QUERYDSL_VERSION}"
    const val QUERYDSL_KAPT = "com.querydsl:querydsl-apt:${DependencyVersions.QUERYDSL_VERSION}:jpa"
}