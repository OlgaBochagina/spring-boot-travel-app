// Селекторы для элементов формы
const form = document.querySelector('form');
const usernameInput = document.querySelector('input[name="username"]');
const emailInput = document.querySelector('input[name="email"]');
const passwordInput = document.querySelector('input[name="password"]');

// URL API для регистрации
const apiUrl = 'http://localhost:8081/auth/register';

// Обработчик отправки формы
form.addEventListener('submit', async function (event) {
    event.preventDefault(); // Останавливаем стандартное поведение формы

    // Считываем данные формы
    const username = usernameInput.value;
    const email = emailInput.value;
    const password = passwordInput.value;

    try {
        // Отправляем запрос на сервер
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                user_name: username, // Поле соответствует вашему API
                email: email,
                password: password,
            }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            alert(errorData.message || 'Ошибка регистрации. Попробуйте снова.');
            return;
        }

        // Если регистрация прошла успешно, перенаправляем на страницу авторизации
        alert('Регистрация прошла успешно! Вы будете перенаправлены на страницу авторизации.');
        window.location.href = 'login.html';
    } catch (error) {
        console.error('Ошибка регистрации:', error);
        alert('Ошибка соединения с сервером. Попробуйте позже.');
    }
});
