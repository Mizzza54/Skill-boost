# Вопрос 18
_Скомпилируется ли приведенный код, и если нет, то на какой строке произойдет ошибка компиляции?_

```java
class MyClass {
    static int a = 1;  // строка 2
    final int b;  // строка 3

    public static void main(String[] args) {
        final int c = 2;  // строка 5
        int d = a + c;  // строка 6
    }
}
```

## Варианты ответов:

- Скомпилируется
- Строка 2
- Строка 3
- Строка 5
- Строка 6

___

Правильный ответ: дописать

### Разбор: