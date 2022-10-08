plugins {
    `java-library`
    id("io.freefair.lombok") version "6.5.1"
    `maven-publish`
}

repositories {
    mavenCentral()
}

tasks {
    compileJava {
        options.release.set(8)
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

group = "org.pircbotx"
version = "2.1-twitchify"

dependencies {
    implementation("com.google.guava:guava:18.0") { because("CharMatcher.WHITESPACE ref") }
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("info.unterrainer.java.tools:nullannotations:0.3")
    implementation("commons-codec:commons-codec:1.10")

    testImplementation("org.testng:testng:6.9.10")
    testImplementation("org.mockito:mockito-core:2.0.40-beta")
    testImplementation("ch.qos.logback:logback-classic:1.1.3")
}