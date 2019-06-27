package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Owner;
import com.ayaz.ayazpetclinic.services.CrudServices;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner , Long > implements CrudServices<Owner , Long> {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }
}
