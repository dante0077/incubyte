package com.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ","; // default delimiter

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        // Replace newline with delimiter
        numbers = numbers.replace("\n", delimiter);

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        List<String> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    negatives.add(String.valueOf(num));
                } else if (num <= 1000) { // ignore numbers >1000
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negative numbers not allowed " + String.join(",", negatives));
        }

        return sum;
    }
}
