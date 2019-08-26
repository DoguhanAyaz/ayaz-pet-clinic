package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Visit;
import com.ayaz.ayazpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit , Long> implements VisitService {
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        return super.save(object);
    }
}
