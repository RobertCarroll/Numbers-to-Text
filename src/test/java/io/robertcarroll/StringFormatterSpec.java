package io.robertcarroll;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringFormatterSpec {
    @Test
    public void translateNumberTest_PhoneNumber(){
        String expected = "twoonefive sevenfivetwo fivetwofoursix";
        String actual = StringFormatter.convertPhoneNumber("215 752 5346");
        assertEquals(expected, actual);
    }

    @Test
    public void translateNumberTest_Clock(){
        String expected = "three forty-five prime meridian";
        String actual = StringFormatter.convertTime("3:45pm");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest(){
        String expected = "two";
        String actual = StringFormatter.convertNumber('2');
        assertEquals(expected, actual);
    }
}
