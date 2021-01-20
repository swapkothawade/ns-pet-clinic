package com.nspc.services.map;

import com.nspc.model.BaseEntity;
import com.nspc.services.PetCrudService;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements PetCrudService<T, ID> {
    Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T t) {
        if (!Objects.isNull(t)) {
            if (t.getId() == null) {
                t.setId(getNextId());
            }
            map.put(t.getId(), t);
        }else{
            throw new RuntimeException("Object can not be NULL");
        }

        return t;
    }

    @Override
    public Set<T> findAll() {
        return this.map.values().stream().collect(Collectors.toSet());
    }

    @Override
    public void delete(T t) {
        map.entrySet().removeIf(item -> item.getValue().equals(t));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public int count() {
        return map.size();
    }

    public Long getNextId() {
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1L;
        }catch (NoSuchElementException exception){
            nextId =1L;
        }
        return nextId;
    }
}
