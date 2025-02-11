package week3;

import week1.Pet;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.out;

public class EnhancedPetRegistry {
    private HashMap<String, Pet> petsByName = new HashMap<>();
    private HashMap<String, Double> petPrices = new HashMap<>();
    private HashMap<Class<?>, ArrayList<Pet>> petsByType = new HashMap<>();

    public void registerPet (Pet pet, double price) {
        petsByName.put(pet.getName(), pet);

        petPrices.put(pet.getName(), price);

        Class<?> petType = pet.getClass();
        petsByType.putIfAbsent(petType, new ArrayList<>());
        petsByType.get(petType).add(pet);

        out.println("Registered " + pet.getName() + " for $" + price);
    }

    public void displayByType() {
        out.println("Pets By type");
        for(Class<?> type: petsByType.keySet()){
            ArrayList<Pet> petsOfType = petsByType.get(type);
            out.println("\n" + type.getSimpleName() + "s (" + petsOfType.size() + "):");

            for (Pet pet : petsOfType) {
                Double price = petPrices.get(pet.getName());
                out.println("  - " + pet.getName() + " ($" + price + ")");
            }

        }


    }
}
