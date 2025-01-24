package week2.animals;

import week2.enumerators.Moods;
import week2.enumerators.Trick;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Dog extends week1.Pet{
    private List<Trick> learnedTricks;

    public Dog( String name, int age, double price) {
        super(name, age, price);
        this.learnedTricks = new ArrayList<>();
    }

    @Override
    public String makeSound() {
        if(getMood() == Moods.HAPPY){
            return "Woof! Woof!";
        }
        return "Woof!";
    }

    @Override
    public void play(){
        out.println("COngratulations, your dong is playing and is happy");
        setMood(Moods.HAPPY);
    }

    public void learnTrick(Trick trick){
        if (!learnedTricks.contains(trick)){
            learnedTricks.add(trick);
            out.println(this.getName() + " learned the trick " + trick);
        }
        else {
            out.println(this.getName() + " already knows this trick " );
        }
    }

    public void listTricks () {
        out.println(this.getName() + " Knows the following tricks: \n");
        for (Trick trick : learnedTricks){
            out.println(trick.getDisplayName() + "\n");
        }
    }

    public void performTrick(Trick trick) {
        if(!learnedTricks.contains(trick)){
            out.println("He doesnt know that trick");
            return;
        }
        out.println(this.getName() + " performs " + trick.getDisplayName());
    }



}
