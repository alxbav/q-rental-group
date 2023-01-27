# Q Rental Group Project

This project uses Spring Boot as, Java Framework.
## Build and run configuration:
Setup next environment variables:
SPRING_DATASOURCE_USERNAME and SPRING_DATASOURCE_PASSWORD

## Running Database schema migration:
All SQL-migration placed in flyway module.
To run migration execute next script:
```shell script
cd flyway
./mvnw clean package
```
## Running application:


## Localisation:
{url}?lang={ee, en, ru}