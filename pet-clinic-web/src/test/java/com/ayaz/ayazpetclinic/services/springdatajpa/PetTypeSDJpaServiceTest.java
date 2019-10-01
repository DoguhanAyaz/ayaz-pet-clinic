package com.ayaz.ayazpetclinic.services.springdatajpa;

import com.ayaz.ayazpetclinic.Repositories.PetTypeRepository;
import com.ayaz.ayazpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetTypeSDJpaServiceTest {
    PetType returnPetType;

    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    PetTypeSDJpaService service;

    @BeforeEach
    void setUp() {
        returnPetType = PetType.builder().Id(1L).name("Pet").build();
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(returnPetType));
        PetType petType = service.findById(1L);
        assertNotNull(petType);
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypes.add(PetType.builder().Id(1L).build());
        petTypes.add(PetType.builder().Id(2L).build());
        when(petTypeRepository.findAll()).thenReturn(petTypes);
        Set<PetType> findPetTypes = service.findAll();
        assertEquals(2,findPetTypes.size());
        ;
    }

    @Test
    void save() {
        PetType petType = PetType.builder().Id(1L).build();
        when(petTypeRepository.save(any())).thenReturn(petType);
        PetType savedPetType = service.save(petType);
        assertNotNull(petType);
    }

    @Test
    void delete() {
        service.delete(returnPetType);
        verify(petTypeRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petTypeRepository).deleteById(anyLong());
    }
}