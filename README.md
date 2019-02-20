# netcrakertask
netcrakertask

## Немного о проекте:
+ Используемый язык Java
+ Сборка проекта Maven
+ Используемый браузер Chrome
+ Работа с браузером осуществляется через библиотеку selenium

## Предварительная настройка для работы программы:
1. Поместите файл keywords.csv в каталог по умолчанию C:\Users\* ,где * - имя вашего компьютера
2. Поместите chromedriver в каталог по умолчанию C:\chromedriver.exe (изменить диск можно в файле application.properties)
3. Заполните файл keywords.csv следующими данными:
  
  ```
  Action,Locator Type,Locator Value,setValue, PATH....
  open_browser,chrome
  open_url,,,https://www.google.com
  set_value,xpath,//*[@id="tsf"]/div[2]/div/div[1]/div/div[1]/input,NetCracker
  click_element,xpath,//*[@id="tsf"]/div[2]/div/div[2]/div[2]/div/center/input[1]
  verify_value,xpath,//*[@id="tsf"]/div[2]/div/div[2]/div/div[1]/input,value,NetCracker
  click_element,id,logo,
  snapshot,,,,d://test2.png
  close_browser
  ```
  
  ## Как правильно формировать файл keywords.csv:
  
  Action,Locator Type,Locator Value,setValue, PATH....
  
  1. Список Action представлен ниже (Описание команд)
  2. Список Locator Type представлен ниже (Типы локаторов)
  3. Locator Value - значение локатора, которое соотвествует Locator Type 
  4. setValue - Установить текстовое значение, которое будет использовано в дальнейшем. Например при вводе слова в поисковую строку
  5. PATH - путь сохранения картинки
  
  
  
  ## Описание команд:
 - open_browser - открывает браузер
 - open_url – переходит на указанный URL
 - click_element – Выполняет нажатие элемента на странице (в качестве параметра
принимает локатор элемента, например xpath)
- setValue – записывает значение в текстовое поле (в качестве параметров
принимает локатор элемента и текст который нужно ввести)
- checkElementVisible – проверяет, что элемент отображается на странице (в
качестве параметра принимает локатор элемента, например xpath)
- snapshot – выполняет снимок экрана

## Типы локаторов:
1. id
2. name
3. xpath
4. css
5. linkText
6. partialLinkText
