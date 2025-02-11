package week5;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main (String[] args){
        Scanner object = new Scanner(System.in);
        out.println("Enter your username");
        String userName = object.nextLine();

        out.println("Hi " + userName);
        out.println("hello week5");
    }
}
