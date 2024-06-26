Feature: Поменять город

  Background: Находимся в разделе медицинские услуги
    Given Открываем сайт "https://www.invitro.ru/radiology/"

  Scenario: В разделе медицинские услуги поменять город, произвести поиск и убедиться,
  что поиск верный и после клика на результат поиска "Омск" отобразился "Омск"
    When Нажимаем на город
    And Нажимаем кнопку выбрать другой
    And Вводим в поиск "Омск"
    Then Проверка результата поиска: отобразился "Омск"


