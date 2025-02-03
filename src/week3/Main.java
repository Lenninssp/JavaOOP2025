package week3;

import week1.Pet;
import week2.animals.Cat;
import week2.animals.Dog;
import week2.animals.Fish;
import week2.enumerators.WaterType;


import static java.lang.System.out;

public class Main {
    public static void main(String[] args){
        out.println("Starting");

        Petshop petShop = new Petshop();

        petShop.addToWaitingList(new Dog("Max", 2, 100.0));
        petShop.addToWaitingList(new Cat("Luna", 1, 100.0));

        Pet nextPet = petShop.processNextPet();
        Pet lastPet = petShop.processLastPet();

        petShop.addPet(new Dog("Buddy", 1, 100.0));
        petShop.addPet(new Cat("Whiskers", 3, 50.0));
        petShop.addPet(new Fish("Nemo", 1, 10.0, WaterType.FRESHWATER));

        out.println("Petsize " + petShop.getPetCount());

        petShop.addPet(new Dog("Coco", 3, 200.0));
        petShop.addPetAt(2, new Cat("Michi", 2, 100.0));
        petShop.addPet(new Fish("Plopplop", 1, 10.0, WaterType.FRESHWATER));
        petShop.addPet(new Dog("Lennin", 13, 1000.0));
        petShop.addPet(new Dog("Lennin2", 1, 1400.0));
        petShop.addPet(new Dog("Gay", 1, 1300.0));
        petShop.addPet(new Cat("Michica", 20, 200.0));
        petShop.addPet(new Fish("Cico", 10, 1.0, WaterType.SALTWATER));
        petShop.addPet(new Dog("Portio", 3, 100.0));
        petShop.addPet(new Cat("Michilafigaca", 2, 20.0));

        Pet oldestPet = petShop.findOldestPet();
        out.println("Oldest " + oldestPet);

        petShop.printPets(petShop.findPetsByAge(1));

        petShop.removePet(3);
        petShop.removePetByInstance(new Dog("Buddy", 1, 100.0));

        petShop.printPets(petShop.findPetsByType(Dog.class));
        petShop.printPets(petShop.findPetsByType(Cat.class));

        petShop.adoptPet("Michica");
        petShop.adoptPet("Robert");

        petShop.killOldPets();
        petShop.printPets();
    }
}
