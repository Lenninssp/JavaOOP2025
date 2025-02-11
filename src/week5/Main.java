package week5;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<Double>();
        Scanner object = new Scanner(System.in);
        out.println("Enter how many numbers you want");

        String input = "0";

        while (true) {
            input = object.nextLine().trim();
            if (Objects.equals(input, "")) break;
            try {
                double transformed = Double.parseDouble(input);
                numbers.add(transformed);
            } catch (NumberFormatException error) {
                out.println("That is an invalid number");
                continue;
            }
        }
        object.close();
        out.println("You inserted this numbers: " + numbers);

        Calculator calculations = new Calculator(numbers);
        out.println(calculations.Mean());
        out.println(calculations.Median());
        out.println(calculations.Mode());

        out.println("hello week5");
    }
}
