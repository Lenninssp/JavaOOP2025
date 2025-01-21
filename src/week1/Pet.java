package week1;

public class Pet {
    private String name;
    private String type;
    private int age;
    private double price;
    private String mood = "normal";

    public Pet (String name, String type, int age, double price) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.price = price;
    }

    @Override
    public String toString() {
        return "The pet is " +
                name +
                ", is a beautiful " + type  +
                " and is " + age + " years old" +
                " That costs $" + price;
    }

    public String makeSound() {
        String lowerType = type.toLowerCase();
        if (lowerType.equals("dog") || lowerType.equals("perro")) {
            return "Woof";
        } else if (lowerType.equals("cat") || lowerType.equals("gato")) {
            return "Miau";
        } else {
            return "*Another weird animal sound*";
        }
    }

    public void play() {
        setMood("Joyful");
        System.out.println(name + " is playing" );
        if (type.equals("dog") || type.equals("perro")){
            System.out.println("Woof WOof WOof Woof");
        }
        if (type.equals("cat") || type.equals("gato")){
            System.out.println("Miau Miau Miau Miau");
        }
        else {
            System.out.println("La estamos pasando buenoooooo, dice tu mascota?");
        }
    }

    public void playWith(Pet otherPet) {
        if (this.type.equals(otherPet.getType())) {
            setMood("happy");
            otherPet.setMood("happy");
            System.out.println(name + " and " + otherPet.getName() +
                    " are playing together!");
        } else if (this.type.equals("cat") &&
                otherPet.getType().equals("dog")) {
            setMood("grumpy");
            otherPet.setMood("grumpy");
            System.out.println(name + " hisses and runs away from " +
                    otherPet.getName());
        }
    }

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
    public void setType(String newType) {
        if (newType != null && !newType.trim().isEmpty()) {
            type = newType;
        } else {
            System.out.println("Error: Type cannot be empty!");
        }
    }
    public String getType(){
        return type;
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
    public String getMood() {
        return mood;
    }
    private void setMood(String newMood) {
        if (newMood != null && !newMood.trim().isEmpty()) {
            mood = newMood;
        }
    }

}
