plugins {
    application
    kotlin("jvm") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.ajalt:clikt:2.5.0")
    implementation("org.koin:koin-core:2.0.1")
    implementation("org.slf4j:slf4j-log4j12:1.7.30")
    implementation("log4j:log4j:1.2.17")
}

application {
    mainClassName = "com.adevinta.MainKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}