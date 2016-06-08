package io.robertcarroll;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumberTranslatorSpec {
    NumberTranslator translator;
    @Before
    public void setUp(){
        translator = new NumberTranslator();
        StringFormatter.populateNumberMap();
        StringFormatter.populateMinuteMap();
    }

    @Test
    public void translateNumberTest_PhoneNumber(){
        String expected = "twoonefive sevenfivetwo fivetwofoursix";
        String actual = translator.translateNumber("(215) 752-5246");
        assertEquals(expected, actual);
    }

    @Test
    public void translateNumberTest_Clock(){
        String expected = "three forty-five post meridiem";
        String actual = translator.translateNumber("3:45pm");
        assertEquals(expected, actual);
    }

    @Test
    public void translateNumberTest_ClockMilitary(){
        String expected = "zero six hundred";
        String actual = translator.translateNumber("06:00");
        assertEquals(expected, actual);
    }
}
