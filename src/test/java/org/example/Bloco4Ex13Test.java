package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bloco4Ex13Test {
    static final Bloco4Ex13 bloco4Ex13 = new Bloco4Ex13();
    @Test
    public void shouldReturnMinValueInIntArray_getMinValueFromArray() {
        int[] numbers = {2, 3, 1, 10, 8};
        boolean minValue = true;
        int expected = 1;
        assertEquals(expected, bloco4Ex13.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinus1ForEmptyArray_getMinValueFromArray() {
        int[] numbers = new int[0];
        boolean minValue = true;
        int expected = -1;
        assertEquals(expected, bloco4Ex13.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturn2ForAllElementsEquals2_getMinValueFromArray() {
        int[] numbers = {2, 2, 2};
        boolean minValue = true;
        int expected = 2;
        assertEquals(expected, bloco4Ex13.getMinOrMaxValueFromArray(numbers, minValue));
    }

    // maxValue
    @Test
    public void shouldReturnMaxValueInIntArray_getMaxValueFromArray() {
        int[] numbers = {2, 3, 1, 10, 8};
        boolean minValue = false;
        int expected = 10;
        assertEquals(expected, bloco4Ex13.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinus1ForEmptyArray_getMaxValueFromArray() {
        int[] numbers = new int[0];
        boolean minValue = false;
        int expected = -1;
        assertEquals(expected, bloco4Ex13.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturn2ForAllElementsEquals2_getMaxValueFromArray() {
        int[] numbers = {2, 2, 2};
        boolean minValue = false;
        int expected = 2;
        assertEquals(expected, bloco4Ex13.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnAverageForAllArrayElements() {
        int[] numbers = {2, 2, 2};
        double expected = 2;
        assertEquals(expected, bloco4Ex13.getAverageFromArrayValues(numbers));
    }

    @Test
    public void shouldReturnMinus1IfNumbersArrayIsLessEqualsZero() {
        int[] numbers = new int[0];
        double expected = -1;
        assertEquals(expected, bloco4Ex13.getAverageFromArrayValues(numbers));
    }

    @Test
    public void shouldReturnProductOfArrayElements() {
        int[] numbers = {2, 2, 2};
        int expected = 8;
        assertEquals(expected, bloco4Ex13.getProductOfArrayElements(numbers));
    }

    @Test
    public void shouldReturnMinus1IfNumbersArrayIsEmpty() {
        int[] numbers = new int[0];
        int expected = -1;
        assertEquals(expected, bloco4Ex13.getProductOfArrayElements(numbers));
    }

    @Test
    public void shouldReturnSetOfNonRepeatedNumbers_getSetOfNonRepeatedNumbersMethod() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, bloco4Ex13.getSetOfNonRepeatedNumbers(numbers));
    }

    @Test
    public void shouldReturnNullIfNumbersArrayIsEmpty_getSetOfNonRepeatedNumbersMethod() {
        int[] numbers = new int[0];
        assertNull(bloco4Ex13.getSetOfNonRepeatedNumbers(numbers));
    }

    @Test
    public void shouldReturnReversedNumbers_getReversedNumbersMethod() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, bloco4Ex13.getReversedNumbers(numbers));
    }

    @Test
    public void shouldReturnNullIfNumbersArrayIsEmpty_getReversedNumbersMethod() {
        int[] numbers = new int[0];
        assertNull(bloco4Ex13.getReversedNumbers(numbers));
    }
}