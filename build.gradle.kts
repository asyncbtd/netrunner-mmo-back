plugins {
    id("java")
    id("org.springframework.boot") version "4.0.0-M2"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.gorylenko.gradle-git-properties") version "2.5.2"
}

group = "net.nrmmo"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    /* ------------------------------- DEPENDENCIES ------------------------------- */
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.0-M1")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("com.nimbusds:nimbus-jose-jwt:9.37.3")

    // data
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-flyway")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")

    implementation("org.mapstruct:mapstruct:1.5.3.Final")

    /* ---------------------------- DEPENDENCIES BUILD ------------------------------- */
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")

    /* ----------------------------------- TEST -------------------------------------- */
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    /* ------------------------------ TEST BUILD ------------------------------------- */
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

gitProperties {
    failOnNoGitDirectory = false
    dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
    keys = listOf(
        "git.branch",
        "git.tags",
        "git.commit.id",
        "git.commit.id.abbrev",
        "git.build.time",
        "git.build.version"
    )
}

tasks.withType<Test> {
    useJUnitPlatform()
}
