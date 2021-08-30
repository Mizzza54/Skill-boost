# Вопрос 17
_В приведенном коде, что нужно указать в строке 6, чтобы код скомпилировался?_

```java
abstract class Parent {
    String str = "a";
    public void printStr() {}
}

public class Child extends Parent {
    // строка 6
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.printStr();
    }
}
```

## Варианты ответов:

- ничего не надо
- public abstract void printStr();
- void printStr() {}
- public Child printStr() {}
- public Parent printStr() {}

___

Правильный ответ: дописать

### Разбор: