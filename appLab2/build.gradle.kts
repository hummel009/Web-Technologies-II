plugins {
	id("java")
	id("war")
}

group = "com.github.hummel"
version = "1.0-SNAPSHOT"

dependencies {
	implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))

	implementation("com.mysql:mysql-connector-j:latest.release")

	implementation("jakarta.servlet:jakarta.servlet-api:latest.release")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:latest.release")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:latest.release")

	implementation("ch.qos.logback:logback-classic:latest.release")

	val junitBom = platform("org.junit:junit-bom:latest.release")
	testImplementation(junitBom)
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
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
