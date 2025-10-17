package com.example;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        // Replace newlines with commas so both work as delimiters
        numbers = numbers.replace("\n", ",");

        String[] tokens = numbers.split(",");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());
        }
        return sum;
    }
}
