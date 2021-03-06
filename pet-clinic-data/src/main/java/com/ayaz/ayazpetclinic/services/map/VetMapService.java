package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Speciality;
import com.ayaz.ayazpetclinic.model.Vet;
import com.ayaz.ayazpetclinic.services.SpecialityService;
import com.ayaz.ayazpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private  final  SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

}
