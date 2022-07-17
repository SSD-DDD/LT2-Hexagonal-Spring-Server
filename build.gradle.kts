plugins {
    kotlin("jvm") version PluginVersions.JVM_VERSION
    id("jacoco")
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = PluginVersions.JVM_VERSION
    }

    apply {
        plugin("org.jetbrains.kotlin.kapt")
        version = PluginVersions.KAPT_VERSION
    }

    apply {
        plugin("jacoco")
    }

    dependencies {
        implementation(Dependencies.KOTLIN_REFLECT)
        implementation(Dependencies.KOTLIN_JDK)
        testImplementation(Dependencies.SPRING_TEST)
        testImplementation(Dependencies.MOCKITO)
        testImplementation(Dependencies.MOCKITO_INLINE)
    }
}

allprojects {
    group = "com.lt2"
    version = "0.0.1-SNAPSHOT"

    tasks.jacocoTestReport {
        classDirectories.setFrom(
            files(classDirectories.files.map {
                fileTree(it) {
                    exclude("**", "**")
                }
            })
        )
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "17"
            }
        }

        compileJava {
            sourceCompatibility = JavaVersion.VERSION_17.majorVersion
        }

        test {
            useJUnitPlatform()
        }
    }
}

repositories {
    mavenCentral()
}

tasks.getByName<Jar>("jar") {
    enabled = false
}
