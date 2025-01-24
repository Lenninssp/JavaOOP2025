package week2.animals;

import week2.enumerators.FishTank;
import week2.enumerators.WaterType;

import static java.lang.System.out;

public class Fish extends week1.Pet{
    private FishTank fishTank =  FishTank.SMALL;
    private WaterType waterType;

    public Fish(String name, int age, double price, WaterType waterType){
        super(name, age, price);
        this.waterType = waterType;
    }

    public void upgradeTankSize (FishTank newTank){
        if (newTank.ordinal() < fishTank.ordinal()){
            out.println("You shouldn't decrease the size if you are trying to upgrade");
            return;
        }
        out.println("Hooeay, that is an amazing new tank");
        fishTank = newTank;
    }

    @Override
    public void play() {
        System.out.println(getName() + " swims through some bubbles in their " +
                fishTank.getDisplayName() + " " +
                waterType.getDisplayName() + " tank!");
    }

    @Override
    public String makeSound(){
        return "Glup Glup Glup";
    }
}
