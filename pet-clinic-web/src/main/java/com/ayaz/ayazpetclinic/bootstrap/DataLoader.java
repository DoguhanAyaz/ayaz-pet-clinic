package com.ayaz.ayazpetclinic.bootstrap;

import com.ayaz.ayazpetclinic.model.*;
import com.ayaz.ayazpetclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);



        Owner owner1 = new Owner();

        owner1.setFirstName("Doguhan");
        owner1.setLastName("Ayaz");
        owner1.setAddress("Akıncılar mah. Posta cad. Yavuz sok. no:18/8");
        owner1.setCity("Istnabul");
        owner1.setTelephone("+905365491115");



        Pet doguhansMet = new Pet();
        doguhansMet.setPetType(saveCatPetType);
        doguhansMet.setOwner(owner1);
        doguhansMet.setBirthDate(LocalDate.now());
        doguhansMet.setName("Riko");
        owner1.getPets().add(doguhansMet);

        ownerService.save(owner1);

        Visit catVisit = new Visit();
        catVisit.setPet(doguhansMet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat Visit");
        Visit savedVisit = visitService.save(catVisit);



//        OWNER 2
        Owner owner2 = new Owner();

        owner2.setFirstName("Nazlı");
        owner2.setLastName("Ayaz");
        owner1.setAddress("Cambridge aveneue No:18/8");
        owner1.setCity("London");
        owner1.setTelephone("+905367073275");

        Pet nazlisPet = new Pet();
        nazlisPet.setPetType(saveDogPetType);
        nazlisPet.setOwner(owner2);
        nazlisPet.setBirthDate(LocalDate.now());
        nazlisPet.setName("karabaş");
        owner2.getPets().add(nazlisPet);


        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Hacer");
        vet1.setLastName("Ayaz");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Mehmet");
        vet2.setLastName("Ayaz");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
