package com.example.day01_fresco01.view;

public interface Iview<E> {
    void requestData(E e);
    void requestFail(E e);
}
