package com.ayaz.ayazpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {


    @Builder
    public Owner(Long id, String firstName, String lastName, String city, String address, String telephone, Set<Pet> pets) {
        super(id,firstName,lastName);
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}
