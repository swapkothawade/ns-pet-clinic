package com.nspc.bootstrap;

import com.nspc.model.Owner;
import com.nspc.model.Pet;
import com.nspc.model.PetType;
import com.nspc.model.Vet;
import com.nspc.services.OwnerService;
import com.nspc.services.PetService;
import com.nspc.services.PetTypeService;
import com.nspc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService,PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------ Data Load Started  -----------------------------");
        PetType dog = new PetType("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        PetType savedCat= petTypeService.save(cat);


        Pet p1 = new Pet();
        p1.setBirthDate(LocalDate.now());
       // p1.setOwner(swara);
        p1.setPetType(savedDog);
        petService.save(p1);

        Pet p2 = new Pet();
        p2.setBirthDate(LocalDate.now());
        //p2.setOwner(neeha);
        p2.setPetType(savedCat);
        petService.save(p2);



        Owner swara = new Owner();
        swara.setFirstName("Swarup");
        swara.setLastName("Kathewadi");
        swara.setAddress("123 JFK");
        swara.setCity("Jersey");
        swara.setTelephone("2012220909");
        ownerService.save(swara);

        Owner neeha = new Owner();
        neeha.setFirstName("Neerav");
        neeha.setLastName("Modi");
        neeha.setAddress("1 Jeferson");
        neeha.setCity("New York");
        neeha.setTelephone("5510908");
        neeha.getPets().add(p1);
        ownerService.save(neeha);

        Owner abc = new Owner();

        abc.setFirstName("ABC");
        abc.setLastName("Patil");
        abc.setAddress("1 Madison Avenue");
        abc.setCity("NewYork city");
        ownerService.save(abc);

        System.out.println("Number of owners Registered  " + ownerService.count());



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
