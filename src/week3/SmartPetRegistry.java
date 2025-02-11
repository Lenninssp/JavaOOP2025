package week3;

import week1.Pet;

import java.util.HashMap;
import java.util.UUID;

import static java.lang.System.out;

public class SmartPetRegistry {
    private HashMap<String, String> idsByName = new HashMap<>();
    private HashMap<String, Pet> petsById = new HashMap<>();

    public String registerPet(Pet pet) {
        String name = pet.getName();
        String id = UUID.randomUUID().toString();

        if (idsByName.containsKey(name)) {
            int count = 1;
            String newName = name;
            while (idsByName.containsKey(name)) {
                count++;
                newName = name + " " + count;
            }
            name = newName;
        }

        idsByName.put(name, id);
        petsById.put(id, pet);

        out.println("Registered: " + name + " (ID: " + id + ")");
        return id;
    }
}
