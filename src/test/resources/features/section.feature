# language: ru
Функционал: Проверка функционала основного раздела Пациентам

  Предыстория: Находимся в разделе медицинские услуги
    Когда открыт сайт 'https://www.invitro.ru/radiology/'

  Структура сценария: Выбор раздела меню
    Когда нажмаем на раздел меню
    И выбираем раздел '<section>'
    Тогда проверяем раздел '<section>'

    Примеры:
      | section     |
      | Франчайзинг |

