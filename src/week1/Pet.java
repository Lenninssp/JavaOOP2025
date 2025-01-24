package week1;

import week2.enumerators.Moods;

public abstract class Pet {
    private String name;
    private int age;
    private double price;
    private Moods mood = Moods.NEUTRAL;

    public Pet (String name, int age, double price) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 0 ){
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        if(price < 0.0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.name = name;
        this.age = age;
        this.price = price;
    }

    @Override
    public String toString() {
        return "The pet is " +
                name +
                " and is " + age + " years old" +
                " That costs $" + price;
    }

    public abstract void play();

    public abstract String makeSound();

    public void setName (String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else{
            System.out.println("Error: name must be not empty");
        }
    }
    public String getName(){
        return name;
    }
    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        } else {
            System.out.println("Error: Age cannot be negative!");
        }
    }
    public int getAge(){
        return age;
    }
    public void setPrice (double price) {
        if( price >= 0.0){
            this.price = price;
        }
    }
    public double getPrice(){
        return price;
    }
    public Moods getMood() {
        return mood;
    }
    public void setMood(Moods newMood) {
        if (newMood != null) {
            mood = newMood;
        }
    }

}
