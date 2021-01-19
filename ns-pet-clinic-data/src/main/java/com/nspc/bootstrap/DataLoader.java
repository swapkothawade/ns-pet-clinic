package com.nspc.bootstrap;

import com.nspc.model.Owner;
import com.nspc.model.Pet;
import com.nspc.model.PetType;
import com.nspc.model.Vet;
import com.nspc.services.OwnerService;
import com.nspc.services.PetService;
import com.nspc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------ Data Load Started  -----------------------------");
        Owner swara = new Owner();
        swara.setId(1L);
        swara.setFirstName("Swarup");
        swara.setLastName("Kathewadi");
        ownerService.save(swara);

        Owner neeha = new Owner();
        neeha.setId(2L);
        neeha.setFirstName("Neerav");
        neeha.setLastName("Modi");
        ownerService.save(neeha);

        Owner abc = new Owner();
        swara.setId(3L);
        abc.setFirstName("ABC");
        abc.setLastName("Patil");
        ownerService.save(abc);

        System.out.println("Number of owners Registered  " + ownerService.count());

        Pet p1 = new Pet();
        PetType petType = new PetType("Dog");
        p1.setId(1L); p1.setBirthDate(LocalDate.now());p1.setOwner(swara);p1.setPetType(petType);
        petService.save(p1);

        Pet p2 = new Pet();
        PetType cat = new PetType("Cat");
        p2.setId(2L); p2.setBirthDate(LocalDate.now());p2.setOwner(neeha);p2.setPetType(cat);
        petService.save(p2);

        System.out.println("Number of Pets Registered  " + petService.count());

        Vet v1 = new Vet();

        v1.setId(1L);
        v1.setFirstName("Prashanth");
        v1.setLastName("Vare");
        vetService.save(v1);

        Vet kedar = new Vet();
        kedar.setId(2L);
        kedar.setFirstName("Krame");
        kedar.setLastName("Jpe");
        vetService.save(kedar);

        Vet sachin = new Vet();
        sachin.setId(3L);
        sachin.setFirstName("John");
        sachin.setLastName("Snowe");
        vetService.save(sachin);

        System.out.println("Number of Vets Registered  " + vetService.count());

        System.out.println("------------------ Data Load Ended  -----------------------------");
    }
}
