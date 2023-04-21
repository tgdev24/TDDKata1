package org.example;

public class StringCalculator {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        String delimeterRegex;
        // use these as delimiters
        delimeterRegex = ",\n";

        // see if there's a custom delimiter present and if so, add to list of delimiters
        if(numbers.length() > 3){
            if(numbers.substring(0, 3).contains("//")) {
                delimeterRegex += numbers.substring(2, numbers.indexOf("\n"));
            }
        }

        String [] nums = numbers.trim().split("[" + delimeterRegex + "]");

        int sum = 0;
        StringBuilder negativeNumsMessage = new StringBuilder();
        for(String num: nums) {
            try {
                int numToAdd = Integer.parseInt(num);
                if(numToAdd < 0) {
                    negativeNumsMessage.append(numToAdd).append(", ");
                }
                sum += numToAdd;
            } catch(Exception e) {
                System.out.println(e);
            }
        }

        if(negativeNumsMessage.length() > 0){
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumsMessage.substring(0, negativeNumsMessage.length()-2));
        }

        return sum;
    }
}