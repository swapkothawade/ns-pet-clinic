package com.nspc.services.map;

import com.nspc.model.Owner;
import com.nspc.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService<Owner,Long> {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner t) {
        super.delete(t);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public List<Owner> findByLastname(String lastname) {
       return  super.map.entrySet().stream()
               .filter(item->item.getValue().getLastName().equalsIgnoreCase(lastname))
               .map(item->item.getValue())
               .collect(Collectors.toList());
    }

}
