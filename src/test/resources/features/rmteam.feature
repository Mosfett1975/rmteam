#language: ru

@test
Функция: RMTeam Website Testing

  Предыстория: Открываем сайт
    Дано совершен переход по ссылке "/routing/public"

  Сценарий: Проверяем переход по кнопке "Продукты"
    Дано текущая страница установлена "Продукты"
    Если выполнено нажатие на кнопку "кнопка Продукты"
    Тогда элемент "Заголовок раздела Продукты" отображается

 Сценарий: Проверяем информацию о продукте
    Дано страница прокручена до появления элемента "Кнопка открытия информации о конструкторе визитки"
    И выполнено нажатие на "Кнопка открытия информации о конструкторе визитки"
    Когда элемент "Модальное окно конструктор визитки" отображается
    И элемент "Картинка в модальном окне" отображается
    Тогда поле "модальное окно описание" содержит текст "Гибкая настройка стиля и оформления визитки, отражение любой информации (фото, видео, ссылки, документы, текст, контакты и т.д.)"


  Сценарий: Проверяем форму Связаться с нами
    Дано текущая страница установлена "Контакты"
    Тогда выполнено нажатие на "Кнопка Контакты"
    И выполнено нажатие на "Кнопка Связаться с нами"
    И поле ввода "ФИО" заполняется значением "Иванов Иван Иванович"
    И поле ввода "EMAIL" заполняется значением "test@example.com"
    И поле ввода "Номер телефона" заполняется значением "phoneNumber"
    И поле ввода "Код подтверждения" заполняется значением "12345"
    Тогда кнопка "Кнопка получения кода подтверждения" активна
    И кнопка "Кнопка Свяжитесь со мной" не активна
    Тогда выполнено нажатие на "Чекбокс персональные данные"
    Тогда выполнено нажатие на "Чекбокс политика конфеденциальности"
    Тогда выполнено нажатие на "Чекбокс пользовательское соглашение"
    И кнопка "Кнопка Свяжитесь со мной" активна