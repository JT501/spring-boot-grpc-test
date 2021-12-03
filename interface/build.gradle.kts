import com.google.protobuf.gradle.*

val grpcKTVersion = "1.2.0"
val grpcVersion = "1.42.1"
val protobufVersion = "3.19.1"

plugins {
    kotlin("jvm") version "1.6.0"
    id("idea")
    id("com.google.protobuf") version "0.8.18"
}

group = "com.jt501"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-kotlin-stub:$grpcKTVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("com.google.protobuf:protobuf-java-util:$protobufVersion")
    implementation("com.google.protobuf:protobuf-kotlin:$protobufVersion")
    compileOnly("jakarta.annotation:jakarta.annotation-api:1.3.5")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKTVersion:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

idea {
    module {
        sourceDirs.add(file("src/generated/main/kotlin"))
        sourceDirs.add(file("src/generated/main/grpckt"))
        generatedSourceDirs.add(file("src/generated/main/kotlin"))
        generatedSourceDirs.add(file("src/generated/main/grpckt"))
    }
}
