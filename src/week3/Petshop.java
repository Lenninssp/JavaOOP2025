package week3;

import week1.Pet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import static java.lang.System.out;

public class Petshop {
    private ArrayList<Pet> pets = new ArrayList<>();
    private LinkedList<Pet> waitingList = new LinkedList<>();

    public void addToWaitingList(Pet pet) {
        waitingList.addLast(pet);
    }

    public Pet processNextPet() {
        return waitingList.pollFirst();
    }

    public Pet processLastPet() {
        return waitingList.pollLast();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addPetAt(int index, Pet pet) {
        pets.add(index, pet);
    }

    public int getPetCount() {
        return pets.size();
    }

    public ArrayList<Pet> findPetsByAge(int age) {
        ArrayList<Pet> filteredList = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getAge() == age) {
                filteredList.add(pet);
            }
        }
        return filteredList;
    }

    public ArrayList<Pet> findPetsByType(Class<?> type) {
        ArrayList<Pet> petList = new ArrayList<>();
        for (Pet pet : pets) {
            if (type.isInstance(pet)) {
                petList.add(pet);
            }
        }
        return petList;
    }

    public Pet findOldestPet() {
        int maxAge = 0;
        Pet oldPet = null;
        for (Pet pet : pets) {
            if (pet.getAge() > maxAge) {
                maxAge = pet.getAge();
                oldPet = pet;
            }
        }
        return oldPet;
    }

    public void adoptPet(String name) {
        Iterator<Pet> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            if (pet.getName().equals(name)) {
                iterator.remove();
                out.println("🎉 The pet " + pet.getName() + " (" + pet.getClass().getSimpleName() + ") was successfully adopted!");
                return;
            }
        }
        out.println("😕 Sorry, couldn't find a pet named " + name);
    }

    public void printPets() {
        out.println("\n\nInventory of the pet store");
        for (Pet pet : pets) {
            out.println("- Name: " + pet.getName() + " (" + pet.getClass().getSimpleName() + ") | Age: " + pet.getAge() + " | Price: " + pet.getPrice());
        }
    }

    public void printPets(ArrayList<Pet> petsList) {
        out.println("\n\nFiltered Pet List");
        for (Pet pet : petsList) {
            out.println("- Name: " + pet.getName() + " (" + pet.getClass().getSimpleName() + ") | Age: " + pet.getAge() + " | Price: " + pet.getPrice());
        }
    }

    public void killOldPets() {
        Iterator<Pet> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            if (pet.getAge() > 10) {
                out.println("Killing " + pet.getName() + " (" + pet.getClass().getSimpleName() + ") ");
                iterator.remove();
            }
        }
    }

    public void removePet(int index) {
        if (index >= 0 && index < pets.size()) {
            pets.remove(index);
        }
    }

    public void removePetByInstance(Pet pet) {
        pets.remove(pet);
    }
}