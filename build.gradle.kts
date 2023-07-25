/*
plugins {
	java
	id("org.springframework.boot") version "3.0.9"
	id("io.spring.dependency-management") version "1.1.2"
//	id("com.vaadin") version "24.1.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_20
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

//extra["springCloudGcpVersion"] = "4.5.1"
extra["springCloudVersion"] = "2022.0.3"
extra["testcontainersVersion"] = "1.18.3"
//extra["vaadinVersion"] = "24.1.2"


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-webflux")
//	implementation("com.google.cloud:spring-cloud-gcp-starter")
//	implementation("com.vaadin:vaadin-spring-boot-starter")

//	implementation("io.micrometer:micrometer-tracing-bridge-brave")
//	implementation("org.apache.kafka:kafka-streams")
//	implementation("org.liquibase:liquibase-core")
//	implementation("org.springframework.kafka:spring-kafka")

	compileOnly("org.projectlombok:lombok")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	developmentOnly("org.springframework.boot:spring-boot-docker-compose")

	runtimeOnly("com.mysql:mysql-connector-j")
//	runtimeOnly("io.micrometer:micrometer-registry-prometheus")

//	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.boot:spring-boot-testcontainers")
//	testImplementation("io.projectreactor:reactor-test")
//	testImplementation("org.springframework.kafka:spring-kafka-test")
	testImplementation("org.testcontainers:junit-jupiter")
//	testImplementation("org.testcontainers:kafka")
	testImplementation("org.testcontainers:mysql")
	testImplementation("org.assertj:assertj-core:3.24.2")

}

dependencyManagement {
	imports {
//		mavenBom("com.vaadin:vaadin-bom:${property("vaadinVersion")}")
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
//		mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${property("springCloudGcpVersion")}")
//		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
*/
