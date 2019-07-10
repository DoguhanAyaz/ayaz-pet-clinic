package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.PetType;
import com.ayaz.ayazpetclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

}
