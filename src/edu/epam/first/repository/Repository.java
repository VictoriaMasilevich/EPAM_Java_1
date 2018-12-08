package edu.epam.first.repository;

public interface Repository<T> {

    void add(T t);

    void remove(T t);
}
