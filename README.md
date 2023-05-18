# Приложение Каршеринг
## Описание проекта
Проект представляет из себя веб-приложение, которые позволяет арендовать автомобиль поминутно, без ограничения по времени. Для написания приложения используется Java 17.
## Зависимости проекта
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    runtimeOnly 'org.postgresql:postgresql'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE'
    implementation 'org.springframework.security:spring-security-test'
}
```
## Запуск проекта
| Система сборки  | Команда  | 
|:------------- |:---------------:   |
| Gradle        | ./gradlew bootrun  | 
