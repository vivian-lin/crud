# crud

spring boot/java CRUD template

### Dependencies
```
brew tap AdoptOpenJDK/openjdk
brew install --cask  adoptopenjdk11
java -version

brew install gradle
```

### Interacting with application
- Run application from command line: `./gradlew bootRun`
- To interact with H2 db: `http://localhost:8080/h2-console` (username and password in application.yml)
- cURL the endpoint from command line:

```
curl --location --request POST 'http://localhost:8080/{INSERT ENDPOINT HERE}' \
--header 'Content-Type: application/json' \
--data-raw 'INSERT JSON HERE'
```

### Tests
Located in `src/test/java`. To run from command line, `./gradlew clean build`
