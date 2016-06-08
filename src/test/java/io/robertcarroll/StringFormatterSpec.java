package io.robertcarroll;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringFormatterSpec {
    @Before
    public void setUp(){
        StringFormatter.populateNumberMap();
        StringFormatter.populateMinuteMap();
    }

    @Test
    public void convertNumberTest_PhoneNumber(){
        String expected = "twoonefive sevenfivetwo fivetwofoursix";
        String actual = StringFormatter.convertPhoneNumber("215 752 5246");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest_CountryCode(){
        String expected = "one twoonefive sevenfivetwo fivetwofoursix";
        String actual = StringFormatter.convertPhoneNumber("1215 752 5246");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest_Clock(){
        String expected = "three o'clock post meridiem";
        String actual = StringFormatter.convertTime("3:00pm");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest_ClockBeforeTenAfter(){
        String expected = "three o'six post meridiem";
        String actual = StringFormatter.convertTime("3:06pm");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest_ClockAfterTenAfter(){
        String expected = "three sixteen ante meridiem";
        String actual = StringFormatter.convertTime("3:16am");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest_ClockMinuteThirtyFive(){
        String expected = "three thirty-five ante meridiem";
        String actual = StringFormatter.convertTime("3:35am");
        assertEquals(expected, actual);
    }

    @Test
    public void convertNumberTest_MilitaryClock(){
        String expected = "zero three thirty-five";
        String actual = StringFormatter.convertTime("3:35");
        assertEquals(expected, actual);
    }


    @Test
    public void convertNumberTest(){
        String expected = "two";
        String actual = StringFormatter.convertNumber("2", StringFormatter.getNumberMap());
        assertEquals(expected, actual);
    }

    @Test
    public void convertFirstMinuteDigitTest(){
        String expected = "twenty-";
        String actual = StringFormatter.convertFirstDigit(22);
        assertEquals(expected, actual);
    }
    @Test
    public void convertSecondMinuteDigitTest(){
        String expected = "two";
        String actual = StringFormatter.convertSecondDigit(22);
        assertEquals(expected, actual);
    }

}
