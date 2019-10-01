package com.ayaz.ayazpetclinic.services.springdatajpa;

import com.ayaz.ayazpetclinic.Repositories.SpecialityRepository;
import com.ayaz.ayazpetclinic.Repositories.VetRepository;
import com.ayaz.ayazpetclinic.model.Vet;
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
class VetSDJpaServiceTest {
    Vet returnVet;

    @Mock
    VetRepository vetRepository;
    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    VetSDJpaService service;

    @BeforeEach
    void setUp() {
        returnVet = Vet.builder().id(1L).firstName("Alex").build();
    }

    @Test
    void findById() {
        when(vetRepository.findById(any())).thenReturn(Optional.of(returnVet));
        Vet alex = service.findById(1L);
        assertNotNull(alex);
    }

    @Test
    void findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetSet.add(Vet.builder().id(1L).build());
        vetSet.add(Vet.builder().id(2L).build());
        when(vetRepository.findAll()).thenReturn(vetSet);
        Set<Vet> vets = service.findAll();
        assertNotNull(vets);
        assertEquals(2,vets.size());
    }

    @Test
    void save() {
        Vet saveVet = Vet.builder().id(1L).build();
        when(vetRepository.save(any())).thenReturn(saveVet);
        Vet savedVet = service.save(saveVet);
        assertNotNull(savedVet);
    }

    @Test
    void delete() {
        service.delete(returnVet);
        verify(vetRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(vetRepository).deleteById(anyLong());
    }
}