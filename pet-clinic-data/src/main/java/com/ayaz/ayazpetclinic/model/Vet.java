package com.ayaz.ayazpetclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
