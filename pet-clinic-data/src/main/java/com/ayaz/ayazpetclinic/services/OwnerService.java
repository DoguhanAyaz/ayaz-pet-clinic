package com.ayaz.ayazpetclinic.services;

import com.ayaz.ayazpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudServices<Owner , Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
