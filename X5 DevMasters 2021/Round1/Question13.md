# Вопрос 13
_Что выведется в результате выполнения приведенного кода?_

```java
LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
for (Integer i : list) {
    list.add(i + 3);
    System.out.print(i);
}
```

## Варианты ответов:

- Выбросится исключение ConcurrentModificationException
- 1
- 123
- 1234567... итд
- Выбросится исключение UnsupportedOperationException
- Ошибка компиляции

___

Правильный ответ: дописать

### Разбор: