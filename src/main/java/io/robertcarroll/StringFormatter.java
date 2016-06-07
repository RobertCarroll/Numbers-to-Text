package io.robertcarroll;

import java.util.HashMap;

public class StringFormatter {
    private static HashMap<Integer, String> numberMap = new HashMap<>(){{
        put()
    }};

    public static String convertNumber(char number){
        return null;
    }

    public static String convertPhoneNumber(String numbers){
        StringBuilder builder = new StringBuilder();

        for(int i =0; i < numbers.length(); i++){
            builder.append(numbers.charAt(i));
        }

        return builder.toString();
    }

    public static String convertTime(String time){
        return null;
    }
}
