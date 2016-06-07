package io.robertcarroll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser{
    private static Pattern numberPattern = Pattern.compile("([0-9])");

    public static boolean phoneNumberCheck(String input){
        int numberCounter = 0;
        Matcher matcher = numberPattern.matcher(input);

        while(matcher.find()){
            numberCounter++;
        }

        if(numberCounter == 10){
            return true;
        }

        return false;
    }

    public static boolean timeNumberCheck(String input){
        return input.matches("(\\d{1,2}):(\\d{2})((?i)am|pm)?");
    }
}
