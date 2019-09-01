package com.ayaz.ayazpetclinic.Repositories;

import com.ayaz.ayazpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet,Long > {
}
