# Вопрос 11
_Какие из нижеперечисленных вариантов не приведут к ошибке компиляции, если поставить их на строку 2, при условии использования java 8?_

```java
public interface MyInterface {
    // строка 2
}
```

## Варианты ответов:

- static int i = 1;
- public static int i = 1;
- default void run() {}
- void run();
- transient int i = 1;
- final void exec(int i);
- void run() {}
- private void run();
- private void run() {}

___

Правильный ответ: дописать

### Разбор: