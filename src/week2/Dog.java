package week2;

import java.util.ArrayList;
import java.util.List;

public class Dog extends week1.Pet{
    private List<Trick> learnedTricks;

    public Dog( String name, int age, double price) {
        super(name, "Dog", age, price);
        this.learnedTricks = new ArrayList<>();
    }

    @Override
    public String makeSound() {
        if(getMood().equals("Happy")){
            return "Woof! Woof!";
        }
        return "Woof!";
    }


    public void learnTrick(Trick trick){
        if (!learnedTricks.contains(trick)){
            learnedTricks.add(trick);
            System.out.println(this.getName() + " learned the trick " + trick);
        }
        else {
            System.out.println(this.getName() + " already knows this trick " );
        }
    }

    public void listTricks () {
        System.out.println(this.getName() + " Knows the following tricks: \n");
        for (Trick trick : learnedTricks){
            System.out.println(trick.getDisplayName() + "\n");
        }
    }

    public void performTrick(Trick trick) {
        if(!learnedTricks.contains(trick)){
            System.out.println("He doesnt know that trick");
            return;
        }
        System.out.println(this.getName() + " performs " + trick.getDisplayName());
    }



}
