plugins {
    kotlin("jvm") version "1.9.20"
    application
}

group = "adventcode"
version = "2025"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

