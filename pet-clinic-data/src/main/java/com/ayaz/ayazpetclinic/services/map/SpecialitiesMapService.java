package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Speciality;
import com.ayaz.ayazpetclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialtiesService {

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }
}
