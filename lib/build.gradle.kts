plugins {
    alias(libs.plugins.jvm)
    `java-library`
    alias(libs.plugins.org.jooq.codegen)
}

repositories {
    mavenCentral()
}

dependencies {
    jooqCodegen(libs.org.testcontainers.postgresql)
    jooqCodegen(libs.org.postgresql)
}

jooq {
  configuration {
    logging = org.jooq.meta.jaxb.Logging.WARN
    jdbc {
        url = "jdbc:postgresql://localhost:5432/test"
        username = "test"
        password = "test"
    }
    generator {
        name = "org.jooq.codegen.KotlinGenerator"
        database {
            name = "org.jooq.meta.postgres.PostgresDatabase"
            includes = ".*"
            excludes = "databasechangelog.*|databasechangeloglock.*|pg_catalog.*|information_schema.*"
        }
        target {
            packageName = "com.mattupstate.jooq"
        }
        generate {
            isKotlinNotNullPojoAttributes = true
            isKotlinNotNullRecordAttributes = true
            isKotlinNotNullInterfaceAttributes = true
        }
        strategy  {
            name = "org.jooq.codegen.DefaultGeneratorStrategy"
        }
    }
  }
}


// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
