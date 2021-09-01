# Вопрос 23
_Каким запросом мы можем выбрать все записи, где вторая буква поля name таблицы **CUSTOMERS** это буква "л"_

## Варианты ответов:

-
  ```sql 
  select * from CUSTOMERS where name like '_л%';
  ```

-
  ```sql 
  select * from CUSTOMERS where name like '%л_';
  ```

-
  ```sql 
  select * from CUSTOMERS where name like '%л%';
  ```

-
  ```sql 
  select * from CUSTOMERS where name in '*л**';
  ```

-
  ```sql 
  select * from CUSTOMERS where name in 'л';
  ```
  
___

Правильный ответ: дописать

### Разбор: