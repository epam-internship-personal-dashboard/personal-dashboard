package com.github.gokolo.go_personal_dashboard;

import java.util.Set;

public interface MapStore<T> {

    void store(T t);

    Set<T> retrieve();

    void delete(T t);

    void modify(T t, T k);

}