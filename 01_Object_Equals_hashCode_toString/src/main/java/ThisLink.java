import java.util.ArrayList;
import java.util.List;

///
/// Использование ссылки this
/// -------------------------
public class ThisLink {

    public static void main(String[] args) {
        //-->
        // Создаём журнал
        Magazine journal = new Magazine();

        // И двух подписчиков
        User A = new User("Петя");
        User B = new User("Вася");
        A.subscribe(journal);
        B.subscribe(journal);

        // Два выпуска журнала
        journal.release("Сентябрь 2014");
        journal.release("Октябрь 2014");
        //<--
    }

    /**
     * Журнал
     */
    static class Magazine {
        /**
         * Подписчики
         */
        List<User> users = new ArrayList<>();

        //-->
        // Когда журнал выходит
        public void release(String name) {
            for (User user : users) {
                // Он отправляется всем подписчикам
                user.send(name);
            }
        }
        //<--

        /**
         * Подписаться на журнал
         *
         * @param user
         */
        public void subscribe(User user) {
            users.add(user);
        }
    }

    static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        public void subscribe(Magazine journal) {
            journal.subscribe(this);
        }

        public void send(String name) {
            System.out.println("Пользователь " + this.name +
                    " получил журнал " + name);
        }
    }
}
