object Dependencies {
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    const val SPRING_STARTER = "org.springframework.boot:spring-boot-starter-web"
    const val SPRING_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    const val JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val MYSQL_CONNECTOR = "mysql:mysql-connector-java"

    const val JWT = "io.jsonwebtoken:jjwt:${DependencyVersions.JWT_VERSION}"

    const val REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    const val KOTLIN_LOGGING = "io.github.microutils:kotlin-logging-jvm:${DependencyVersions.KOTLIN_LOGGING_VERSION}"
}