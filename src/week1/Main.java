package week1;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Lennin!");

        System.out.println("🏪 WELCOME TO JAVA PET SHOP 🏪\n");
        System.out.println("Our adorable pets:");

        Pet myPet = new Pet("Jorge", "Perro", 14);
        Pet anotherPet = new Pet("Whiskers", "Cat", 5);
        Pet weirdPet = new Pet("Godofredo", "Elephant?", 45);

        System.out.println(myPet);
        System.out.println(anotherPet);
        System.out.println(weirdPet);

        System.out.println(myPet.MakeSound());
        System.out.println(anotherPet.MakeSound());
        System.out.println(weirdPet.MakeSound());

    }
}
