plugins {
	id("java")
	id("org.springframework.boot") version "latest.release"
	id("io.spring.dependency-management") version "latest.release"
}

group = "com.github.hummel"
version = "1.0-SNAPSHOT"

dependencies {
	implementation("com.mysql:mysql-connector-j:latest.release")

	implementation("jakarta.servlet:jakarta.servlet-api:latest.release")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:latest.release")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:latest.release")

	implementation("ch.qos.logback:logback-classic:latest.release")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-test")

	compileOnly("org.apache.tomcat.embed:tomcat-embed-jasper")

}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

tasks {
	test {
		useJUnitPlatform()
	}
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}
