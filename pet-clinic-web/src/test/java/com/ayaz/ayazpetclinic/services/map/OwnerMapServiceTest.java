package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Ayaz";


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        ownerMapService.save(Owner.builder().Id(ownerId).lastName(lastName).build());
    }

    @Test
    void findById() {
       Owner owner  = ownerMapService.findById(ownerId);
       assertEquals(ownerId,owner.getId()); //SOR!!!!
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2l;
        Owner owner2 = Owner.builder().Id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id , savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saved = ownerMapService.save(Owner.builder().build());
        assertNotNull(saved);
        assertNotNull(saved.getId());
    }

    @Test
    void findByLastName() {
        Owner ayaz = ownerMapService.findByLastName(lastName);
        assertNotNull(ayaz);
        assertEquals(ownerId,ayaz.getId());
    }
}