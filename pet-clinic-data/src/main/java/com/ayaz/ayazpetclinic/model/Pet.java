package com.ayaz.ayazpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private String name;
    private PetType petType;
    private Owner Owner;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return Owner;
    }

    public void setOwner(Owner owner) {
        Owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
