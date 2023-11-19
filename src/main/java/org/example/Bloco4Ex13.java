package org.example;

public class Bloco4Ex13 {
    static Bloco4Utils bloco4Utils = new Bloco4Utils();
    public int getMinOrMaxValueFromArray(int[] numbers, boolean minValue) {
        return bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue);
    }

    public double getAverageFromArrayValues(int[] numbers) {
        return bloco4Utils.getAverageFromArrayValues(numbers);
    }

    public int getProductOfArrayElements(int[] numbers) {
        return bloco4Utils.getProductOfArrayElements(numbers);
    }

    public int[] getSetOfNonRepeatedNumbers(int[] numbers) {
        return bloco4Utils.getSetOfNonRepeatedNumbers(numbers);
    }

    public int[] getReversedNumbers(int[] numbers) {
        if (numbers.length == 0) return null;

        int[] reversedNumbers = new int[numbers.length];
        for (int i = numbers.length - 1, j = 0; i >= 0; i--, j++) {
            reversedNumbers[j] = numbers[i];
        }

        return reversedNumbers;
    }
}
