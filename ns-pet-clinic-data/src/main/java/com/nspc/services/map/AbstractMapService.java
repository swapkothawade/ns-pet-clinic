package com.nspc.services.map;

import com.nspc.services.PetCrudService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractMapService<T, ID> implements PetCrudService<T, ID> {
    Map<ID,T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }


    public T save(ID id,T t) {
        map.put(id,t);
        return t;
    }

    @Override
    public Set<T> findAll() {
        return this.map.values().stream().collect(Collectors.toSet());
    }

    @Override
    public void delete(T t) {
        map.entrySet().removeIf(item->item.getValue().equals(t));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
    @Override
    public int count() {
        return map.size();
    }
}
