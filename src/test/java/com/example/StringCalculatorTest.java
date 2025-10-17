package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void add_emptyString_returnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add("")); // expected, actual
    }

    @Test
    void add_singleNumber_returnsThatNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    void add_twoNumbers_commaSeparated_returnsTheirSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }

}
