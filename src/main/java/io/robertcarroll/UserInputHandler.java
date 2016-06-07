package io.robertcarroll;

import java.util.Scanner;

public class UserInputHandler {
    private static Scanner input = new Scanner(System.in);

    public static void promptUser(String message){
        System.out.println(message);
    }

    public static String getNumber(String message){
        promptUser(message);
        return input.nextLine();
    }
}
