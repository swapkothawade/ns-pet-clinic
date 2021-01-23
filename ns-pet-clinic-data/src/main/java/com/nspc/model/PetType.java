package com.nspc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pet_types")
public class PetType extends BaseEntity {
    @Column(name="pet_type")
    private String type;

    public PetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
