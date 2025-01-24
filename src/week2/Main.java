package week2;

import week1.Pet;

import static java.lang.System.out;

public class Main {
    public static void main (String[] args){
        Dog myDog = new Dog("Jorge", 1, 230.0);
        Cat myCat = new Cat("Miuchi", 3, 100.00);
        PetShow myPetShow = new PetShow();

        out.println(myDog + " " + myDog.makeSound());
        out.println(myCat + " " + myCat.makeSound());

        myDog.learnTrick(Trick.FETCH);
        myDog.listTricks();
        myDog.performTrick(Trick.FETCH);

        myCat.learnTrick(Trick.ROLLOVER);
        myCat.listTricks();
        myCat.performTrick((Trick.ROLLOVER));

        Pet pet1 = new Dog("Clara", 1, 1.0);
        Pet pet2 = new Cat("Chia", 1, 1.0);

        displayPet(pet1);
        displayPet(pet2);

        myPetShow.addPet(myDog);
        myPetShow.addPet(myCat);
        myPetShow.addPet(pet1);
        myPetShow.addPet(pet2);

        myPetShow.showPets();
        myPetShow.startShow();
        
    }

    private static void displayPet(Pet pet){
        out.println(pet);
        if(pet instanceof Dog){
            out.println("What a beautiful Dog man");
        }
        if(pet instanceof Cat){
            out.println("What a beautiful Cat man");
        }
    }
}
