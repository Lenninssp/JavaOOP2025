package week1;

public class Pet {
    public String name;
    public String type;
    public int age;

    public Pet (String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

    }

    @Override
    public String toString() {
        return "The pet is " +
                name +
                ", is a beautiful " + type  +
                " and is " + age + " years old";
    }

    public String MakeSound() {
        String lowerType = type.toLowerCase();
        if (lowerType.equals("dog") || lowerType.equals("perro")) {
            return "Woof";
        } else if (lowerType.equals("cat") || lowerType.equals("gato")) {
            return "Miau";
        } else {
            return "*Another weird animal sound*";
        }
    }
}
