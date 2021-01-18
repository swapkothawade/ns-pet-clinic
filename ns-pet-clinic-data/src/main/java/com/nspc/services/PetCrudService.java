package com.nspc.services;

import java.util.Set;

public interface PetCrudService<T,ID> {
    T findById(ID id);
    T save(T t);
    Set<T> findAll();
    void delete(T t);
    void deleteById(ID id);
}
