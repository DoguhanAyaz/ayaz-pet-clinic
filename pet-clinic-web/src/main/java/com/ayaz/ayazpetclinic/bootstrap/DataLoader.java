package com.ayaz.ayazpetclinic.bootstrap;

import com.ayaz.ayazpetclinic.model.Owner;
import com.ayaz.ayazpetclinic.model.Vet;
import com.ayaz.ayazpetclinic.services.OwnerService;
import com.ayaz.ayazpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();

        owner1.setFirstName("Doguhan");
        owner1.setLastName("Ayaz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Nazlı");
        owner2.setLastName("Ayaz");

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
