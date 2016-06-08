package io.robertcarroll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {
    private static HashMap<Integer, String> numberMap = new HashMap<>();
    private static HashMap<Integer, String> minuteMap = new HashMap<>();
    private static Pattern numberPattern = Pattern.compile("([0-9])");

    public static void populateNumberMap(){
        numberMap.put(0, "zero");
        numberMap.put(1, "one");
        numberMap.put(2, "two");
        numberMap.put(3, "three");
        numberMap.put(4, "four");
        numberMap.put(5, "five");
        numberMap.put(6, "six");
        numberMap.put(7, "seven");
        numberMap.put(8, "eight");
        numberMap.put(9, "nine");
        numberMap.put(10, "ten");
        numberMap.put(11, "eleven");
        numberMap.put(12, "twelve");
        numberMap.put(13, "thirteen");
        numberMap.put(14, "fourteen");
        numberMap.put(15, "fifteen");
        numberMap.put(16, "sixteen");
        numberMap.put(17, "seventeen");
        numberMap.put(18, "eighteen");
        numberMap.put(19, "nineteen");
    }
    public static void populateMinuteMap(){
        minuteMap.put(2, "twenty-");
        minuteMap.put(3, "thirty-");
        minuteMap.put(4, "forty-");
        minuteMap.put(5, "fifty-");

    }

    public static HashMap<Integer, String> getNumberMap(){
        return numberMap;
    }

    public static HashMap<Integer, String> getMinuteMap(){
        return minuteMap;
    }

    public static String convertNumber(String number, HashMap<Integer, String> hashMap){
        for(Integer key : hashMap.keySet()){
            if(key == Integer.parseInt(number)){
                return hashMap.get(key);
            }
        }
        return " ";
    }

    public static String convertPhoneNumber(String input){
        Matcher matcher = numberPattern.matcher(input);
        ArrayList<String> numbers = new ArrayList<>();

        while(matcher.find()){
            numbers.add(convertNumber(matcher.group(1), numberMap));
        }

        if(numbers.size() == 10){
            return String.format("%s%s%s %s%s%s %s%s%s%s", numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5), numbers.get(6), numbers.get(7), numbers.get(8), numbers.get(9));
        }

        return String.format("%s %s%s%s %s%s%s %s%s%s%s", numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5), numbers.get(6), numbers.get(7), numbers.get(8), numbers.get(9), numbers.get(10));
    }

    public static String convertTime(String time){
        if(time.matches("(\\d{1,2}):(\\d{2})((?i)a\\.?m\\.?)")){
            return convertStandardTime(time, "ante meridiem");
        }else if(time.matches("(\\d{1,2}):(\\d{2})((?i)p\\.?m\\.?)")){
            return convertStandardTime(time, "post meridiem");
        }

        return convertMilitaryTime(time);
    }

    public static String convertFirstDigit(int minute){
        String firstDigit = String.valueOf(minute).substring(0,1);
        return convertNumber(firstDigit, minuteMap);
    }

    public static String convertSecondDigit(int minute){
        String firstDigit = String.valueOf(minute).substring(1);
        return convertNumber(firstDigit, numberMap);
    }

    public static String convertMinutesStandard(int minutes){
        if(minutes < 10){
            return " o'" + convertNumber(String.valueOf(minutes), numberMap);
        }else if(minutes >= 10 && minutes <= 19){
            return " " + convertNumber(String.valueOf(minutes), numberMap);
        }

        return " " + convertFirstDigit(minutes) + convertSecondDigit(minutes);
    }

    public static String convertMinutesMilitary(int minutes){
        if(minutes == 0){
            return " hundred";
        }else if(minutes < 10){
            return " zero" + convertNumber(String.valueOf(minutes), numberMap);
        }else if(minutes >= 10 && minutes <= 19){
            return " " + convertNumber(String.valueOf(minutes), numberMap);
        }

        return " " + convertFirstDigit(minutes) + convertSecondDigit(minutes);
    }

    public static String convertStandardTime(String time, String meridiem){
        String[] hoursAndMinutes = time.split(":");
        int hours = Integer.parseInt(hoursAndMinutes[0]);
        int minutes = Integer.parseInt(hoursAndMinutes[1].substring(0,2));

        String hourText = convertNumber(hoursAndMinutes[0], numberMap);

        if(minutes == 0){
            return hourText + " o'clock " + meridiem;
        }

        return hourText + convertMinutesStandard(minutes) + " " + meridiem;
    }

    public static String convertMilitaryTime(String time){
        String[] hoursAndMinutes = time.split(":");
        int hours = Integer.parseInt(hoursAndMinutes[0]);
        int minutes = Integer.parseInt(hoursAndMinutes[1]);

        if(hours == 0 && minutes == 0){
            return "zero hundred";
        }else if(hours < 10){
            return "zero " + convertNumber(String.valueOf(hours), numberMap) + convertMinutesMilitary(minutes);
        }else if(hours >= 10 && hours <= 19){
            return convertNumber(String.valueOf(hours), numberMap) + convertMinutesMilitary(minutes);
        }

        return convertFirstDigit(minutes) + convertSecondDigit(minutes) + convertMinutesMilitary(minutes);
    }
}
