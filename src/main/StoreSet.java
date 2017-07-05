package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class StoreSet<T> implements Store<T> {
    private int count = 0;

    private HashMap<Integer, T> hMap = new HashMap<Integer, T>();

    @Override
    public void store(T t) {
        hMap.put(++count, t);
    }

    @Override
    public Set<T> retrieve() {        
        return new HashSet<>(hMap.values());
    }

    @Override
    public void delete(T t) {
        for (Iterator<Entry<Integer, T>> it = hMap.entrySet().iterator(); it.hasNext();) {
            Entry<Integer, T> entry = it.next();
            if (entry.getValue().equals(t)) {
                it.remove();
            }
        }
    }

    @Override
    public void modify(T t, T k) {
        delete(t);
        store(k);
    }

}
