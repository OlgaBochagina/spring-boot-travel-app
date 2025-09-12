# Информационно-справочная система туристического агентства

## Описание
Проект представляет собой информационно-справочную систему для управления туристическим агентством, разработанную в рамках курсовой работы по дисциплине «Современные технологии программирования».

Приложение реализовано на архитектуре **MVC (Model-View-Controller)** с разделением доступа в зависимости от ролей:
- Клиент — просмотр туров и управление своими бронированиями
- Менеджер — управление бронированиями клиентов
- Администратор — управление пользователями, турами и контролем системы

## Функциональность
- Регистрация и авторизация пользователей (JWT)
- Личный кабинет клиента: просмотр туров, бронирования, история поездок
- Панель менеджера: добавление, удаление и просмотр бронирований
- Панель администратора: управление турами и клиентами, просмотр данных
- Безопасность с помощью Spring Security и разграничение прав доступа

## Используемые технологии
- Backend: Java 21, Spring Boot, Spring Security, Spring Data JPA  
- Frontend: HTML, CSS, JavaScript, Thymeleaf  
- База данных: PostgreSQL  
- ORM: Hibernate / JPA  
- Прочее: JWT для аутентификации, Lombok, Gradle
  
## Структура проекта

I_love_java
 ┣ .idea/                  # Настройки IntelliJ IDEA (можно исключить из репозитория)
 ┣ build.gradle            # Файл сборки Gradle
 ┣ gradlew / gradlew.bat   # Скрипты для запуска Gradle Wrapper
 ┣ settings.gradle         # Конфигурация Gradle проекта
 ┣ src
 ┃ ┣ main
 ┃ ┃ ┣ java/com/example/demo20
 ┃ ┃ ┃ ┣ config/           # Конфигурация приложения (Spring Security, JWT, CORS)
 ┃ ┃ ┃ ┣ controller/       # Контроллеры MVC и REST API
 ┃ ┃ ┃ ┣ dto/              # DTO-объекты для передачи данных
 ┃ ┃ ┃ ┣ obj/              # Сущности JPA (Clients, Bookings, Tours, User, Roles)
 ┃ ┃ ┃ ┣ repo/             # Репозитории Spring Data JPA
 ┃ ┃ ┃ ┣ service/          # Сервисный слой (бизнес-логика)
 ┃ ┃ ┃ ┗ TravelAgencyApplication.java # Главный класс запуска Spring Boot
 ┃ ┃ ┗ resources
 ┃ ┃ ┃ ┣ static/           # Статические ресурсы (HTML, CSS, JS)
 ┃ ┃ ┃ ┣ templates/        # Шаблоны Thymeleaf (если используются)
 ┃ ┃ ┃ ┗ application.properties # Настройки приложения (БД, порты и др.)
 ┃ ┗ test/                 # Тесты (юнит и интеграционные)
 ┗ README.md               # Документация проекта

## Запуск проекта
1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/OlgaBochagina/spring-boot-travel-app.git
   cd I_love_java
2. Настроить application.properties (подключение к PostgreSQL, логин/пароль).
3. Запустить проект:
```bash
./gradlew bootRun
4. Открыть в браузере: http://localhost:8080
