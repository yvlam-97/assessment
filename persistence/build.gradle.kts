plugins {
    id("java")
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "nl.pr"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":domain"))

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}