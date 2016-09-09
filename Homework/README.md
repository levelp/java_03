Домашнее задание - запись и чтение из файла
===========================================

Самостоятельная реализация сериализации.

* Создать любой класс с набором полей.
* Сохранить его в текстовый файл используя Reflection API
* Загрузить его из текстового файла:
 * Создать новый экземпляр класса с помощью newInstance
 * Загружать значения полей

Пример класса, в котором есть поля всех примитивных типов:
```java
public class AllCases {
    public int publicInt = 3;
    protected int protectedInt = 2;
    byte aByte = 10;
    short aShort = 111;
    int aInt = 1213;
    long aLong = 1225324234;
    float aFloat = 21432.1f;
    double aDouble = 12345.5678;
    char aChar = 'A';
    boolean aBoolean = true;
    private int privateInt = 1;
}
```

Пример текстового файла:
```
AllCases
publicInt = 3
protectedInt = 2
aByte = 10
aShort = 111
aInt = 1213
aLong = 1225324234
aFloat = 21432.1
aDouble = 12345.5678
aChar = A
aBoolean = true
privateInt = 1
```
  
