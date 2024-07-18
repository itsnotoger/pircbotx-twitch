plugins {
    `java-library`
    id("io.freefair.lombok") version "8.6"
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = "org.pircbotx"
version = "2.1.3-twitchify"

tasks {
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11));
    }
    withSourcesJar()
//    withJavadocJar() TODO needs a lot of fixing
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = group.toString()
            artifactId = rootProject.name
            version = version.toString()

            from(components["java"])
        }
    }
}

dependencies {
    api("com.google.guava:guava:32.0.0-android")

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("info.unterrainer.java.tools:nullannotations:0.3")
    implementation("commons-codec:commons-codec:1.10")

    testImplementation("org.testng:testng:6.9.10")
    testImplementation("org.mockito:mockito-core:2.0.40-beta")
    testImplementation("ch.qos.logback:logback-classic:1.1.3")
}