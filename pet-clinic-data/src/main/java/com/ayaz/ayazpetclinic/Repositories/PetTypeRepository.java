package com.ayaz.ayazpetclinic.Repositories;

import com.ayaz.ayazpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetTypeRepository extends CrudRepository<PetType , Long> {
    Set<PetType> findAll();
}
