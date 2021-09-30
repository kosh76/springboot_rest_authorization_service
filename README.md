# springboot_rest_authorization_service + NGINX
## Описание: 
Это простой сервис авторизации, демонстрация обратного proxy с применением NGINX. При переходе по адресу localhost/signin клиент получает статическую страницу авторизации (login, password)
 далее  nginx переводит клиента  на localhost:8080/  где крутится spring boot приложение на Tomcat. При валидации логина и пароля пользователь получает список Enum(образец того, что service работает). 
 Если такого пользователя нет, выбрасывается Exception и выводится сообщение , что такого пользователя нет.
 ## Установка:
 Скачать и установить  nginx https://nginx.org/download/nginx-1.20.1.zip. Далее заменить конфиг  файл nginx.config на nginx_config.txt находящийся в resources приложения, поместить index.html находящийся в resources в папку sites/auth/www так, чтобы папка находилась в одном каталоге с папкой nginx.
 Запустить springboot приложение , запустить nginx , nginx -s reload.
