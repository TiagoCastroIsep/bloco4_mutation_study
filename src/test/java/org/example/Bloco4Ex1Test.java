package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Bloco4Ex1Test {
    static final Bloco4Ex1 bloco4Ex1 = new Bloco4Ex1();
    @Test
    public void shouldReturnCorrectValue() {
        int number = 123;
        int expected = 3;
        assertEquals(expected, bloco4Ex1.getNumberOfDigitsOfPositiveInt(number));
    }

    @Test
    public void shouldReturnCorrectValueForSingleDigitNumber() {
        int number = 0;
        int expected = 1;
        assertEquals(expected, bloco4Ex1.getNumberOfDigitsOfPositiveInt(number));
    }

    @Test
    public void shouldReturnCorrectValueForSingleDigitNumberWhenNumberIs1() {
        int number = 1;
        int expected = 1;
        assertEquals(expected, bloco4Ex1.getNumberOfDigitsOfPositiveInt(number));
    }

    @Test
    public void shouldReturnMinus1ForNumberLessThanZero() {
        int number = -1;
        int expected = -1;
        assertEquals(expected, bloco4Ex1.getNumberOfDigitsOfPositiveInt(number));
    }

    @Test
    public void shouldReturnMinus1ForNumberMoreThanMaxLimit() {
        int number = 1000000001;
        int expected = -1;
        assertEquals(expected, bloco4Ex1.getNumberOfDigitsOfPositiveInt(number));
    }
}