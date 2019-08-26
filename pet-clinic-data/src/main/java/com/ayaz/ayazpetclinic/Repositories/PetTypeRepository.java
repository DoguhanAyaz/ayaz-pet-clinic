package com.ayaz.ayazpetclinic.Repositories;

import com.ayaz.ayazpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType , Long> {
}
