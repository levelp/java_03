public class Test1<T extends Comparable<T>> {
    private T field;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
    }

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}
