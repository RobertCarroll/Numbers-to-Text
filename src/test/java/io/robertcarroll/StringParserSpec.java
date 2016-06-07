package io.robertcarroll;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringParserSpec {
    @Test
    public void phoneNumberCheckTest_ValidNumber(){
        assertTrue(StringParser.phoneNumberCheck("(215)-688-2132"));
    }

    @Test
    public void phoneNumberCheckTest_InvalidNumber(){
        assertFalse(StringParser.phoneNumberCheck("(215)-688-21322"));
    }

    @Test
    public void clockNumberCheckTest_ValidTime(){
        assertTrue(StringParser.timeNumberCheck("3:35am"));
    }

    @Test
    public void clockNumberCheckTest_InvalidTime(){
        assertFalse(StringParser.timeNumberCheck("3:335am"));
    }
}
