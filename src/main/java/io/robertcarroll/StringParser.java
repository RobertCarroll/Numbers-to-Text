package io.robertcarroll;

public class StringParser{
    public static boolean timeNumberCheck(String input){
        return input.matches("(\\d{1,2}):(\\d{2})((?i)a\\.?m\\.?|p\\.?m\\.?)?");
    }

    public static boolean phoneNumberCheck(String input) {
        return input.matches("^\\d{10}$|^[1]?(\\s|-)?\\(?[0-9]{3}\\)?(\\s|-)?[0-9]{3}(\\s|-)?[0-9]{4}$");
    }
}
