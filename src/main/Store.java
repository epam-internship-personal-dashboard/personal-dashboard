package main;

import java.util.Set;

public interface Store<T> {

    void store(T t);

    Set<T> retrieve();

    void delete(T t);

    void modify(T t, T k);

}
