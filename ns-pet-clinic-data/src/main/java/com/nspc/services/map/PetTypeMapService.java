package com.nspc.services.map;

import com.nspc.model.PetType;
import com.nspc.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService  extends AbstractMapService<PetType,Long> implements PetTypeService{
    @Override
    public PetType save(PetType pet) {

        return super.save( pet);
    }

    @Override
    public PetType findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Set<PetType> findAll() {

        return super.findAll();
    }

    @Override
    public void delete(PetType pet) {

        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }
}
