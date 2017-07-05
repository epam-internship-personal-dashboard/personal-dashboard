package main;

public interface Store<T> {

    void store(T t);

    void retrieve();

    boolean modify(T t);

    void delete(T t);

    boolean store();
}
