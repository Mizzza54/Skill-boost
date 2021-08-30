# Вопрос 5
_Что выведется в результате выполнения приведенного кода?_

```java
class Parent {
    public void call() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    private void call() {
        System.out.println("Child");
    }
    
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.call();
    }
}
```

## Варианты ответов:

- Ошибка компиляции
- Parent
- Child
- Исключение в runtime
- ParentChild

___

Правильный ответ: дописать

### Разбор: