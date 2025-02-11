package week3;

import week1.Pet;

import java.util.TreeSet;

import static java.lang.System.out;

public class SortedPetRegistry {
    private TreeSet<Pet> petsByAge;

    public SortedPetRegistry() {
        petsByAge = new TreeSet<>((Pet p1, Pet p2) -> {
            int ageCompare = Integer.compare(p1.getAge(), p2.getAge());
            return ageCompare != 0 ? ageCompare :
                    p1.getName().compareTo(p2.getName());
        });
    }

    public void addPet(Pet pet){
        petsByAge.add(pet);
    }

    public void displaySortedPets(){
        out.println("Pets By Age:");
        for(Pet pet : petsByAge) {
            out.println("- " +pet.getName() + " (Age: " + pet.getAge() + ")");
        }
    }
}
