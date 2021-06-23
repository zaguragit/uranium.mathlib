import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    `maven-publish`
}

group = "io.posidon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.posidon"
            artifactId = "uranium.mathLib"
            version = "1.0.0"

            from(components["kotlin"])
        }
    }
}