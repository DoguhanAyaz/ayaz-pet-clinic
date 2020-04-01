package com.ayaz.ayazpetclinic.Repositories;

import com.ayaz.ayazpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OwnerRepository extends CrudRepository<Owner  , Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
    Set<Owner> findAll();
}
