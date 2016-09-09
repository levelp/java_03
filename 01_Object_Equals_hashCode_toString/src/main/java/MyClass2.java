/**
 * Добавляем правильно реализованный метод hashCode
 */
public class MyClass2 extends MyClass {
    public MyClass2(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
