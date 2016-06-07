package io.robertcarroll;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumberTranslatorSpec {
    NumberTranslator translator;
    @Before
    public void setUp(){
        translator = new NumberTranslator();
    }

    @Test
    public void translateNumberTest_PhoneNumber(){
        String expected = "twoonefive sevenfivetwo fivetwofoursix";
        String actual = translator.translateNumber("(215) 752-5346");
        assertEquals(expected, actual);
    }

    @Test
    public void translateNumberTest_Clock(){
        String expected = "three forty-five prime meridian";
        String actual = translator.translateNumber("3:45pm");
        assertEquals(expected, actual);
    }
}
