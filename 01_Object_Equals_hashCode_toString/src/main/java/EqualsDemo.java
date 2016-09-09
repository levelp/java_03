/**
 * Сравнение объектов
 */
public class EqualsDemo {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println("p1==p2 = " + (p1 == p2));
        System.out.println("p1.equals(p2) = " + p1.equals(p2));
    }

    /**
     * Точка на плоскости
     */
    static class Point {
        /**
         * Координаты точки
         */
        public int x, y;

        /**
         * Конструктор
         *
         * @param x
         * @param y
         */
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * @param o - объект с которым сравнивается текущий
         * @return true - если объекты равны
         * false - если не равны
         */
        @Override
        public boolean equals(Object o) {
            // Сравниваем классы
            // Если классы не равны => объекты не равны
            if (!o.getClass().equals(Point.class))
                return false;
            // Приводим объект к тому же типу
            // и сравниваем поля
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
    }
}
