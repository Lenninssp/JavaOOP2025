package week2;

public class Cat extends week1.Pet{
    public Cat ( String name, int age, double price){
        super(name, "Cat", age, price);
    }

    @Override
    public String makeSound(){
        if(getMood().equals("Happy")){
            return "Miauw! Miauw!";
        }
        return "Miauw";
    }
}
