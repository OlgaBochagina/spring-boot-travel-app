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
│ │ │ │ ├── config                  # Конфигурации приложения (Spring Security, CORS, JWT и т.д.)
│ │ │ │ ├── controller              # REST-контроллеры (AdminController, AuthController, ManagerController, ClientsController)
│ │ │ │ ├── DataTransferObject      # DTO-классы для передачи и валидации данных (LoginRequest, RegisterRequest, TokenResponse)
│ │ │ │ ├── obj                     # Основные сущности (Bookings, Clients, Roles, Tours, User)
│ │ │ │ ├── repo                    # Репозитории JPA для работы с БД (BookingsRepository, ClientsRepository и т.д.)
│ │ │ │ ├── service                 # Сервисы с бизнес-логикой (AuthService, BookingsService, ClientsService и др.)
│ │ │ │ ├── GlobalExceptionHandler  # Глобальная обработка исключений
│ │ │ │ └── TravelAgencyApplication # Главный класс запуска Spring Boot приложения
│ │ ├── resourses/
│ │ │ ├── static/
│ │ │ │ ├── admin.html     # Интерфейс панели администратора
│ │ │ │ ├── client.html    # Личный кабинет клиента
│ │ │ │ ├── index.html     # Главная страница
│ │ │ │ ├── login.html     # Страница авторизации
│ │ │ │ ├── login.js       # Скрипт обработки авторизации
│ │ │ │ ├── manager.html   # Панель менеджера
│ │ │ │ ├── register.html  # Страница регистрации
│ │ │ │ ├── register.js    # Скрипт обработки регистрации
└── ... 

## Запуск проекта
```
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
