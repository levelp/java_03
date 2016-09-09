/**
 * Мой класс
 * Пример несогласованной реализации equals и hashCode
 */
public class MyClass {
    String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MyClass))
            return false;
        return name.equals(((MyClass) obj).name);
    }
}
