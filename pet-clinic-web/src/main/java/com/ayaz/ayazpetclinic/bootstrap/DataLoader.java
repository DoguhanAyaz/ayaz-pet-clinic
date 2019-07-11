package com.ayaz.ayazpetclinic.bootstrap;

import com.ayaz.ayazpetclinic.model.Owner;
import com.ayaz.ayazpetclinic.model.Pet;
import com.ayaz.ayazpetclinic.model.PetType;
import com.ayaz.ayazpetclinic.model.Vet;
import com.ayaz.ayazpetclinic.services.OwnerService;
import com.ayaz.ayazpetclinic.services.PetTypeService;
import com.ayaz.ayazpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();

        owner1.setFirstName("Doguhan");
        owner1.setLastName("Ayaz");
        owner1.setAdress("Akıncılar mah. Posta cad. Yavuz sok. no:18/8");
        owner1.setCity("Istnabul");
        owner1.setTelephone("+905365491115");

        Pet doguhansMet = new Pet();
        doguhansMet.setPetType(saveCatPetType);
        doguhansMet.setOwner(owner1);
        doguhansMet.setBirthDate(LocalDate.now());
        doguhansMet.setName("Riko");
        owner1.getPets().add(doguhansMet);

        ownerService.save(owner1);

//        OWNER 2
        Owner owner2 = new Owner();

        owner2.setFirstName("Nazlı");
        owner2.setLastName("Ayaz");
        owner1.setAdress("Cambridge aveneue No:18/8");
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

        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Mehmet");
        vet2.setLastName("Ayaz");

        vetService.save(vet2);

        System.out.println("Loaded Vets");


    }
}
