# Веб-проект на Java Spring, JS.
#### Студент GeekBrains: Абдюшев Р.Н.
#### GU | Разработчик | 2042
<br>

## Промежуточная аттестация
### Веб приложение "Игрушки"

#### Конструкция приложения
Сделано full-stack веб-приложение с использованием Java Spring.
Данные сохраняются в MySQL.
Веб-страницы - HTML, Css, JavaScript.
Домашняя работа находится в папке "/toysShopSpring".
Папка "data_json" - для txt файлов с данными БД в MySQL.
* ToysShopSpringApplication.java - main файл для запуска приложения;
* /src/main/java/com/java/toysShopSpring/toysShopSpring - путь к данному файлу;
* /controllers - паккидж с контроллерами в которых прописан маппинг;    
* /models - модель "игрушка";
* /dao - класс - обращение к БД MySQL, запись и чтение;
* /workWithCard - класс в котором прописаны методы по сохранению изображений на сервере<br>
для карточки продукта; логика для сохранения обновленных после выигрыша данных.
* /resources - папка с JavaScript, HTML, Css. В HTML стоят шаблонизаторы Thymeleaf.
<br>

#### Конструкция веб-страниц
* http://localhost:8080/main - Интерфейс главной веб страницы;
    > на основании данных MySQL формируется страница с карточками игрушек<br>
    > Карточка игрушек забирает из БД: название игрушки, ID, кол-во<br>
    > в каждой карточке есть поле "чек" для логики уменьщения кол-ва<br>
    > игрушек в стоке.<br>
    > Кнопка "Новая карточка" - для перехода на страницу формирования новой<br>
    > карточки игрушки;<br>
    > Кнопка "Списать выигранные" - для взятия информации с фронта и отражения<br>
    > в бэке и БД<br>;
    > Кнопка "Сохранить в файл" - для сохранения информации в txt файл на сервере.<br>
* http://localhost:8080/new - Интерфейс веб страницы для создания новой карточки игрушки;
    > вводятся название, кол-во и сложность выигрыша<br>
    > а также пользователем загружается картинка из фронта и дальше<br>
    > файл записывается на сервере.
    > кнопка возврата в main.




