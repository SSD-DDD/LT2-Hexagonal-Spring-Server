plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
    id ("org.jetbrains.kotlin.plugin.allopen") version PluginVersions.ALLOPEN_VERSION
    id ("org.jetbrains.kotlin.plugin.noarg") version PluginVersions.NOARG_VERSION
}

group = "com.lt2"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.JPA)
    implementation(Dependencies.SPRING_SECURITY)
    implementation(Dependencies.SPRING_VALIDATION)
    implementation(Dependencies.SPRING_STARTER)
    runtimeOnly(Dependencies.MYSQL_CONNECTOR)
    implementation(Dependencies.JACKSON)
    implementation(Dependencies.JWT)
    implementation(project(":lt2-domain"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}