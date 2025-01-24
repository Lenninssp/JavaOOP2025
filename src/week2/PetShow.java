package week2;

import week1.Pet;
import week2.animals.Cat;
import week2.animals.Dog;
import week2.enumerators.Trick;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class PetShow {
    private List<Pet> petList;

    public PetShow() {
        this.petList = new ArrayList<>();
    }

    public void addPet(Pet pet){
        if(petList.contains(pet)){
            out.println("This pet is already addded");
            return;
        }
        petList.add(pet);
        out.println("The pet " + pet.getName() +  " was successfully added");
    }

    public void showPets(){
        out.println("List of added pets for the pet show:");
        for(Pet pet : petList) {
            out.println("-" + pet.getName() + " " + pet.getType());
        }
    }

    public void startShow(){
        out.println("List of added pets for the pet show:");
        for(Pet pet : petList) {
            out.println("-" + pet.getName() + " does an amazing trick");
            if(pet instanceof Dog){
                out.println(Trick.ROLLOVER);
            }
            if(pet instanceof Cat){
                out.println(Trick.SALUTE);
            }
        }
    }
}
