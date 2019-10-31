package com.ayaz.ayazpetclinic.Repositories;

import com.ayaz.ayazpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner  , Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
    Set<Owner> findAll();
}
