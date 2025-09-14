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
```i_love_java-master/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── com.example.demo20/
│ │ │ │ ├── config/
│ │ │ │ ├── controller
│ │ │ │ ├── DataTransferObject
│ │ │ │ ├── obj
│ │ │ │ ├── repo
│ │ │ │ ├── service
│ │ │ │ ├── GlobalExceptionHandler
│ │ │ │ └── TravelAgencyApplication
│ │ ├── resourses/
│ │ │ ├── static/
│ │ │ │ ├── admin.html
│ │ │ │ ├── client.html
│ │ │ │ ├── index.html
│ │ │ │ ├── login.html
│ │ │ │ ├── login.js
│ │ │ │ ├── manager.html
│ │ │ │ ├── register.html
│ │ │ │ ├── register.js
└── ... ```

## Запуск проекта
1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/OlgaBochagina/spring-boot-travel-app.git
   cd I_love_java
2. Настроить application.properties (подключение к PostgreSQL, логин/пароль).
3. Запустить проект:
```bash
./gradlew bootRun
```
4. Открыть в браузере: http://localhost:8080
