package com.demo.inter;

public interface ILinkedList<T> {

    boolean isEmpty();

    int length();

    T get(int index);

    T set(int index, T data);

    boolean add(int index, T data);

    boolean add(T data);

    T remove(int index);

    boolean removeAll(T data);

    void clear();

    boolean contains(T data);

    String toString();

}