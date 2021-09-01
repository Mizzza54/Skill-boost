# Вопрос 24
_Каким запросом мы можем посчитать количество клиентов с именем Илья (поле name) в таблице **CUSTOMERS**?_

## Варианты ответов:

-
  ```sql 
  select count(1) from CUSTOMERS where name = 'Илья'
  ```

-
  ```sql 
  select count(*) from CUSTOMERS where name = 'Илья'
  ```

-
  ```sql 
  select count(*) from CUSTOMERS group by name having name = 'Илья'
  ```

-
  ```sql 
  select count, name from CUSTOMERS order by name where rownum = 1
  ```

-
  ```sql 
  select count(name = 'Илья') from CUSTOMERS
  ```
  
___

Правильный ответ: дописать

### Разбор: