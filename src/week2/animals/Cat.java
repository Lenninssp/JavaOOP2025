package week2.animals;

import week2.enumerators.Moods;
import week2.enumerators.Trick;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Cat extends week1.Pet{
    private List<Trick> learnedTricks;
    public Cat ( String name, int age, double price){
        super(name, age, price);
        this.learnedTricks = new ArrayList<>();
    }

    @Override
    public String makeSound(){
        if(getMood() == Moods.HAPPY){
            return "Miauw! Miauw!";
        }
        return "Miauw";
    }

    @Override
    public void play(){
        out.println("The cat is playing and now is happy");
        setMood(Moods.HAPPY);
    }

    public void learnTrick(Trick trick){
        if (learnedTricks.contains(trick)){
            out.println(this.getName() + " already knows this trick");
            return;
        }
        this.learnedTricks.add(trick);
        out.println(this.getName() + " learned this trick");
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
