package com.ayaz.ayazpetclinic.services;

import com.ayaz.ayazpetclinic.model.Owner;

public interface OwnerService extends CrudServices<Owner , Long> {

    Owner findByLastName(String lastName);

}
