package week1;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Lennin!");

        System.out.println("🏪 WELCOME TO JAVA PET SHOP 🏪\n");
        System.out.println("Our adorable pets:");

        Pet myPet = new Pet("Jorge", "Perro", 14, 100);
        Pet anotherPet = new Pet("Whiskers", "Cat", 5, 100);
        Pet weirdPet = new Pet("Godofredo", "Elephant?", 45, 100);

        System.out.println(myPet);
        System.out.println(anotherPet);
        System.out.println(weirdPet);

        System.out.println(myPet.makeSound());
        System.out.println(anotherPet.makeSound());
        System.out.println(weirdPet.makeSound());

        weirdPet.setPrice(1230.0);
        weirdPet.setPrice(-100);
        weirdPet.setName(null);
        weirdPet.setAge(-10);
        weirdPet.setType(null);
        System.out.println(weirdPet);

    }
}
