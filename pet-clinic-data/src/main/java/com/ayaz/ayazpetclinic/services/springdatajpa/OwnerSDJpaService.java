package com.ayaz.ayazpetclinic.services.springdatajpa;

import com.ayaz.ayazpetclinic.Repositories.OwnerRepository;
import com.ayaz.ayazpetclinic.Repositories.PetRepository;
import com.ayaz.ayazpetclinic.Repositories.PetTypeRepository;
import com.ayaz.ayazpetclinic.model.Owner;
import com.ayaz.ayazpetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastname) {
        return ownerRepository.findAllByLastNameLike(lastname);
    }

    @Override
    public Owner findById(Long id) {

        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = ownerRepository.findAll();
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
