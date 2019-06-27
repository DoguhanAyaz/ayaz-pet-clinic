package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Pet;
import com.ayaz.ayazpetclinic.model.Vet;
import com.ayaz.ayazpetclinic.services.CrudServices;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements CrudServices<Vet,Long> {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }
}
