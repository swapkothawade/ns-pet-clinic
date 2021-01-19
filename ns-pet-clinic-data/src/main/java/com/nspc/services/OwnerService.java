package com.nspc.services;

import java.util.List;

public interface OwnerService<Owner,Long> extends PetCrudService<Owner,Long> {
    List<Owner> findByLastname(String lastname);
}
