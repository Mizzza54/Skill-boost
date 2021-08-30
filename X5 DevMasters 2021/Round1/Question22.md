# Вопрос 22
_Известно, что в таблице CUSTOMERS была неправильно заведена почта (поле email) для записей с идентификатором (поля id) с 10 по 20й. Каким запросом можно удалить записи в поле email для этих записей?_

## Варианты ответов:

```sql
update customers set email = null where id between 10 and 20;
```

```sql
select email, null from customers where id between 10 and 20 for update;
```

```sql
update customers set email = null where id in (10,20);
```

```sql
alter table customers set email = null where id >= 10 and id <= 20;
```

```sql
alter table customers set email = null where id between 10 and 20;
```

___

Правильный ответ: дописать

### Разбор: