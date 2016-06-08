package io.robertcarroll;

import static io.robertcarroll.StringParser.*;
import static io.robertcarroll.StringFormatter.*;

public class NumberTranslator {
    public String translateNumber(String input){
        populateNumberMap();
        populateMinuteMap();

        if(phoneNumberCheck(input)){
            return convertPhoneNumber(input);
        }else if(timeNumberCheck(input)){
            return convertTime(input);
        }

        return "Unsupported input";
    }
}
