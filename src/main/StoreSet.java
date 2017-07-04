package main;

import java.util.HashMap;

public class StoreSet<T> implements Store<T> {
    private static int count = 0;

    private HashMap<Integer, T> hMap = new HashMap<Integer, T>();

    @Override
    public void store(T t) {
        hMap.put(mapKey(), t);
    }

    @Override
    public T retrieve() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean modify(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(T t) {
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
