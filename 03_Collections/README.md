<!-- doc.py -->
List, Set, Map, TreeMap, Iterator, ListIterator, Collections. empty
-------------------------------------------------------------------

https://habrahabr.ru/post/128269/
Структуры данных в картинках. ArrayList


``` java

/**
 * Бинарное дерево поиска
 * Левый наследник всегда меньше правого.
 * Для балансировки: CartesianTree? Декартово дерево поиска?
 */
class BinaryTree<T extends Comparable> implements SearchTree<T> {
    /**
     * Корневой элемент дерева
     */
    TreeNode root = null;

    /**
     * Добавление нового значения в дерево поиска
     *
     * @param value добавляемое значение
     */
    @Override
    public void add(T value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode cur = root;
        // Бесконечный цикл, т.к. мы выходим только когда нашли узел
        // к которому можем "подвесить" новый узел, и тогда мы выходим
        // по return
        while (true) {
            if (value.compareTo(cur.value) > 0) {
                if (cur.right == null) {
                    // Мы нашли нужный узел, подвешиваем
                    cur.right = newNode;
                    return;
                }
                // Спускаемся "направо"
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    // Мы нашли нужный узел
                    cur.left = newNode;
                    return;
                }
                // Спускаемся "налево"
                cur = cur.left;
            }
        }
    }

    /**
     * Поиск значения в дереве поиска
     *
     * @param value Значение
     * @return найдено ли значение?
     */
    @Override
    public boolean find(T value) {
        // Спускаемся вниз по дереву поиска
        TreeNode cur = root;
        while (cur != null) {
            // Нашли узел с нужным значением
            if (cur.value.equals(value))
                return true;
            // Выбираем куда идти дальше
            cur = (value.compareTo(cur.value) > 0) ? cur.right : cur.left;
        }
        return false;

    }

    @Override
    public int deep() {
        return (root == null) ? 0 : root.deep();
    }

    /**
     * Узел дерева
     */
    public class TreeNode {
        T value;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(T value) {
            this.value = value;
        }

        /**
         * @return глубина дерева
         */
        int deep() {
            int res = 1;
            if (left != null)
                res = max(res, left.deep() + 1);
            if (right != null)
                res = max(res, right.deep() + 1);
            return res;
        }
    }
}
```

[src/main/java/BinaryTree.java](src/main/java/BinaryTree.java)

List
[src/test/java/A_ListTest.java](src/test/java/A_ListTest.java)

``` java
        // Интерфейс =  Класс с реализацией этого интерфейса
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
        assertFalse(tree.find(3));
        tree.add(3);
        assertTrue(tree.find(3));
        assertFalse(tree.find(2));

        // Добавить новое значение
        tree.add(2);
        assertTrue(tree.find(2));
        assertTrue(tree.find(3));

        // Добавляем узел с большим значением
        tree.add(334);
        assertTrue(tree.find(2));
        assertTrue(tree.find(3));
        assertTrue(tree.find(334));
        assertFalse(tree.find(7789));
```

[src/test/java/BinaryTreeTest.java](src/test/java/BinaryTreeTest.java)

