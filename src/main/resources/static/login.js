const apiUrl = 'http://localhost:8081';

const extractRole = (token) => {
    try {
        // Split the token into parts (header, payload, signature)
        const parts = token.split('.');
        if (parts.length !== 3) {
            throw new Error('Invalid token format');
        }

        // Decode the payload (second part)
        const payload = JSON.parse(atob(parts[1]));

        // Return the role
        return payload.role;
    } catch (error) {
        console.error('Error decoding token:', error);
        return null;
    }
};

document.getElementById('loginForm').addEventListener('submit', async function (e) {
    e.preventDefault(); // Останавливаем стандартное поведение формы

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');

    try {
        const response = await fetch(`${apiUrl}/auth/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        });

        if (response.ok) {
            const data = await response.json();
            const token = data.token; // jwt token
            const role = extractRole(token);

            // Сохраняем токен и ID клиента в localStorage
            localStorage.setItem('jwt', token);
            // if (data.clientId) {
            //     localStorage.setItem('clientId', data.clientId);
            // }

            // Перенаправляем на страницу в зависимости от роли пользователя
            if (role === 'ADMIN') {
                window.location.href = 'admin.html';
            } else if (role === 'MANAGER') {
                window.location.href = 'manager.html';
            } else if (role === 'CLIENT') {
                window.location.href = 'client.html';
            } else {
                throw new Error('Неизвестная роль пользователя');
            }
        } else {
            const errorData = await response.json();
            errorMessage.textContent = errorData.message || 'Ошибка авторизации. Проверьте данные.';
        }
    } catch (error) {
        console.error('Ошибка:', error);
        errorMessage.textContent = 'Не удалось подключиться к серверу.';
    }
});
