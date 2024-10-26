plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.book.manager"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.mybatis.generator:mybatis-generator-core:1.4.0") // MyBatis Generatorの依存関係
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1") // mybatis-dynamic-sqlのみに変更
	implementation("mysql:mysql-connector-java:8.0.27")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// MyBatis Generatorのタスク設定
tasks.register("generateMyBatis") {
	group = "mybatis"
	description = "Run MyBatis Generator"

	doLast {
		javaexec {
			mainClass.set("org.mybatis.generator.api.ShellRunner")
			classpath = sourceSets["main"].runtimeClasspath
			args = listOf("-configfile", "${projectDir}/src/main/resources/mybatis-generator.xml", "-overwrite")
		}
	}
}
