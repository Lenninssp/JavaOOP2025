package week3;

import week1.Pet;

import java.util.HashMap;

import static java.lang.System.out;

public class PetRegistry {
    private HashMap<String, Pet> petsByName = new HashMap<>();

    public void registerPet (Pet pet) {
        petsByName.put(pet.getName(), pet);
        out.println("Pet successfully added");

    }

    public Pet findPetByName( String name){
        return petsByName.get(name);
    }

    public void printAllPets() {
        out.println("Printing all pets");
        for (String name : petsByName.keySet()){
            Pet pet = petsByName.get(name);
            out.println("Pet name is " + pet.getName() + " and his age is " + pet.getAge() + " and is a " + pet.getClass().getSimpleName());
        }
    }
}
