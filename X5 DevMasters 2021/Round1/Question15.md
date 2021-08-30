# Вопрос 15
_Что выведется в результате выполнения приведенного кода?_

```java
class Parent {
    String str = "Parent";
    
    String getStr() {return str;}
}

class Child extends Parent {
    String str = "Child";

    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.str + obj.getStr());
    }
}
```

## Варианты ответов:

- ParentParent
- ChildParent
- ChildChild
- Ошибка компиляции
- Исключение в runtime
- ParentChild

___

Правильный ответ: дописать

### Разбор: