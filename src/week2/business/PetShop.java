package week2.business;

import week1.Pet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class PetShop {
    private String name;
    private String address;
    private List<Pet> pets = new ArrayList<>();

    public PetShop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String addPet(Pet newPet){
        if (pets.contains(newPet)){
            return "The pet is already in the pet shop";
        }
        pets.add(newPet);
        return "The pet was successfully added in the pet store";
    }

    public void printPets(){
        for (Pet pet : pets){
            out.println(String.format("The pet %s is %d years old and is very %s", pet.getName(), pet.getAge(), pet.getMood()));
        }
    }

    public void playWithAllPets(){
        for (Pet pet: pets){
            pet.play();
        }
    }
    public List<Pet> getPets(){
        return pets;
    }
}
