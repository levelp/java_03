import java.util.ArrayList;

/**
 * Пример хеш-таблицы
 */
class HashTable {

    private final int size;
    private final boolean[] exists;
    private final ArrayList[] lists;

    HashTable(int size) {
        this.size = size;
        this.exists = new boolean[size];
        this.lists = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            lists[i] = new ArrayList();
        }
    }

    int hash(Object obj) {
        return obj.hashCode() % size;
    }

    public void add(Object obj) {
        int h = hash(obj);
        exists[h] = true;
        lists[h].add(obj);
    }


    Object get(Object key) {
        int h = hash(key);
        if (!exists[h])
            return null;
        for (Object obj : lists[h])
            if (obj.equals(key))
                return obj;
        return null;
    }
}
