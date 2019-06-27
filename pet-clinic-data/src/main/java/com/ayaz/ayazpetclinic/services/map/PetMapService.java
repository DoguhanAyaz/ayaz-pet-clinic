package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Pet;
import com.ayaz.ayazpetclinic.services.CrudServices;
import com.ayaz.ayazpetclinic.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet , Long> implements CrudServices<Pet , Long> {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
