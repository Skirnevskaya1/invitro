# language: ru
Функционал: Отправляем запрос

  Структура сценария: Отправляем запрос, получаем статус код ответа 200 и тело ответа
    Когда отправляем запрос 'https://www.invitro.ru/local/ajax/current-city.php?CODE=<code>'

    Примеры:
      | code   |
      | moscow |
      | london |
      | bajmak |
