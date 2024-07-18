plugins {
    `java-library`
    id("io.freefair.lombok") version "8.6"
    `maven-publish`
    id("org.gradlex.extra-java-module-info") version "1.8"
}

repositories {
    mavenCentral()
}

group = "com.github.itsnotoger"
version = "2.5.1-twitchify"

tasks {
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
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
    api("com.google.guava:guava:33.2.1-jre")

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.slf4j:slf4j-api")
    implementation("commons-codec:commons-codec:1.13")

    implementation("org.jetbrains:annotations")

    testImplementation("org.testng:testng:7.7.0")
    testImplementation("org.mockito:mockito-core:2.0.40-beta")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")

    constraints {
        implementation("org.slf4j:slf4j-api") {
            version { require("2.0.9") }
            because("modularized jar needed")
        }
        implementation("org.jetbrains:annotations") {
            version { require("24.1.0") }
            because("modularized jar needed")
        }
    }
}

extraJavaModuleInfo {
    module("com.google.guava:listenablefuture", "guava.listenablefuture")
    module("com.google.code.findbugs:jsr305", "javax.annotation") {
        exports("javax.annotation")
        exports("javax.annotation.concurrent")
        exports("javax.annotation.meta")
    }
}

configurations {
    listOf("testCompileClasspath", "testRuntimeClasspath").forEach { configName ->
        named(configName).configure {
            attributes.attribute(Attribute.of("javaModule", Boolean::class.javaObjectType), false)
        }
    }
}
