package main;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StoreSet<T> implements Store<T> {
    private static int count = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private HashMap<Integer, T> hMap = new HashMap<Integer, T>();

    @Override
    public void store(T t) {
        hMap.put(mapKey(), t);
    }

    @Override
    public void retrieve() {
        Set<Entry<Integer, T>> set = hMap.entrySet();
        for (Entry<Integer, T> me : set) {
            System.out.println(me.getValue());
        }
    }

    @Override
    public boolean modify(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public delete(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean store() {
        // TODO Auto-generated method stub
        return false;
    }

    private static int mapKey() {
        count++;
        return count;
    }

}
