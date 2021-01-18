package com.nspc.services;

import com.nspc.model.Owner;

public interface OwnerService extends PetCrudService<Owner,Long>{
    Owner findByLastname(String lastname);
}
