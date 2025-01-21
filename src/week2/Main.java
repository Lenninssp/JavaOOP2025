package week2;

public class Main {
    public static void main (String[] args){
        Dog myDog = new Dog("Jorge", 1, 230.0);
        Cat myCat = new Cat("Miuchi", 3, 100.00);

        System.out.println(myDog + " " + myDog.makeSound());
        System.out.println(myCat + " " + myCat.makeSound());


    }
}
