package com.ayaz.ayazpetclinic.services;

import java.util.Set;

public interface CrudServices<T, Id> {
    T findById (Id id);

    Set<T> findAll();

    T save (T object);

    void delete(T object);

    void deleteById(Id id);
}
