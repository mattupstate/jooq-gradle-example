# jooq-gradle-example

NOTE: This does not appear to generate any code yet.

This illustrates how to use the official jOOQ Gradle plugin.

Run the following:

```
$ docker run -d \
    -p 5432:5432 \
    -e POSTGRES_USER=test \
    -e POSTGRES_PASSWORD=test \
    -e POSTGRES_DB=test \
    -v ./lib/src/main/resources/db/migrations:/docker-entrypoint-initdb.d \
    postgres:15.5

$ ./gradlew jooqCodegen
```
