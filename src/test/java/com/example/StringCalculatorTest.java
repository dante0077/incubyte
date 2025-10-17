package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testSingleNumberReturnsValue() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void testTwoNumbersReturnSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    public void testNewlineAsSeparator() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    void add_customDelimiter_returnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
        assertEquals(15, calc.add("//|\n4|5|6"));
    }

    @Test
    void add_negativeNumbers_throwsException() {
        StringCalculator calc = new StringCalculator();

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> calc.add("1,-2,3,-4"));

        assertEquals("negative numbers not allowed -2,-4", exception.getMessage());
    }

}
