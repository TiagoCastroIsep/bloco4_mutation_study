package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class orderCrescentTest {
    static OrderCrescent orderCrescent = new OrderCrescent();

    @Test
    public void crescent() {
        int[] vector = {0, 2, -1, 2, 5, 4, 3};
        int[] expected = {-1, 0, 2, 2, 3, 4, 5}; // changed to be able to pass mutation testing
        int[] result = orderCrescent.orderCrescent(vector);
        assertArrayEquals(expected, result);
    }

    @Test
    public void crescentAllDiferent() {
        int[] vector = {0, 2, -1, 6, 5, 4, 3};
        int[] expected = {-1, 0, 2, 3, 4, 5, 6};
        int[] result = orderCrescent.orderCrescent(vector);
        assertArrayEquals(expected, result);
    }

    @Test
    public void crescentAllDiferentAndOrdered() {
        int[] vector = {7, 6, 5, 4, 3, 2, 1, 0};
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] result = orderCrescent.orderCrescent(vector);
        assertArrayEquals(expected, result);
    }

    @Test
    public void crescentAllEquals() {
        int[] vector = {1, 1, 1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1, 1, 1};
        int[] result = orderCrescent.orderCrescent(vector);
        assertArrayEquals(expected, result);
    }

    @Test
    public void crescentEmpty() {
        int[] vector = {};
        int[] expected = {};
        int[] result = orderCrescent.orderCrescent(vector);
        assertArrayEquals(expected, result);
    }

    @Test
    public void crescentOne() {
        int[] vector = {1};
        int[] expected = {1};
        int[] result = orderCrescent.orderCrescent(vector);
        assertArrayEquals(expected, result);
    }
}