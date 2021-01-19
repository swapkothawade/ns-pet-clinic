package com.nspc.model;

public class PetType extends BaseEntity {
    private String type;

    public PetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
