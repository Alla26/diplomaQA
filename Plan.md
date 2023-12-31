# **Тест - план мобильного приложения «Мобильный хоспис».**

## **1. Описание приложения**

Приложение «Мобильный хоспис» даёт функционал по работе с претензиями хосписа и включает в себя:

* информацию о претензиях и функционал для работы с ними;
* новостную сводку хосписа;
* тематические цитаты.

## **2. Проверка приложения**

Данные для авторизации:  
`login2;`  
`password2.`

**Состав приложения:**

1. Экран авторизации
2. Главный экран, который содержит 

      * меню:
         * главная страница
         * новости
         * претензии
         * информация о приложении
     * раздел с тематическими цитатами
     * кнопка logout

Главная страница содержит два раздела: **Новости** и **Претензии**.  Для каждого раздела предусмотрен собственный набор функциональности.

**1.1 Новости:**
* просмотр;
* по кнопке All news:
    * сортировка;
    * фильтр;
    * редактирование:
       * сортировка;
       * фильтр;
       * добавление новой новости.

**1.2 Претензии:**
* просмотр;
* добавление новой претензии;
* по кнопке All claims:
   * добавление новой претензии;
   * фильтр.
   
* находясь внутри претензии:
    * добавление комментария;
    * изменение статуса;
    * редактирование;
    * возврат к списку.

Страница с информацией о приложении содержит две ссылки: на политику конфиденциальности и условия использования.

## **3. Функционал, подлежащий проверке**

В рамках дипломной работы будет проведено функциональное тестирование методом белого ящика, а также нефункциональное UI тестирование.  
Цели функционального тестирования - проверка корректности работы функций приложения; нефункционального тестирования - проверка соответствия пользовательского интерфейса ожидаемым требованиям.

**Проверяемый функционал:**
* Авторизация и разлогин пользователя
* Добавление новой новости
* Работа с существующими новостями
* Добавление новой претензии
* Работа с существующими претензиями
* Просмотр информации о приложении по ссылкам
* Просмотр тематических цитат


**Функционал, планируемый к автоматизации**

*Планируется осуществить автоматизацию тех сценариев, которые отражают ключевые функции исследуемого приложения:*

* Авторизация и разлогин пользователя
* Добавление новой новости
* Добавление новой претензии
* Просмотр информации о приложении по ссылкам
* Просмотр тематических цитат

Побочные сценарии, такие как редактирование ранее созданных объектов, не подлежат автоматизации во избежание увеличения трудоемкости.

## **4. Инструменты, используемые в работе**

* **Android Studio** для запуска приложения на реальном устройстве и эмуляторах, а также для написания и прогона тестов
* **Espresso** для написания автотестов и их запуска
* **Github** для хранения проекта и контроля версий
* **Allure** для подготовки отчетности о тестировании



