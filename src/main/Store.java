package main;

public interface Store<T> {

    void store(T t);

    T retrieve();

    boolean modify(T t);

    boolean delete(T t);

    boolean store();
}
