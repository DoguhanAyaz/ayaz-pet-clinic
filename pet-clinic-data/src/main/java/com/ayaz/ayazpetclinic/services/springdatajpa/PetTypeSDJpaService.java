package com.ayaz.ayazpetclinic.services.springdatajpa;

import com.ayaz.ayazpetclinic.Repositories.PetTypeRepository;
import com.ayaz.ayazpetclinic.model.PetType;
import com.ayaz.ayazpetclinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Slf4j
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null) ;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = petTypeRepository.findAll();
        return petTypes;
    }

    @Override
    public PetType save(PetType object) {
        //TO-DO Modelden taşı
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
