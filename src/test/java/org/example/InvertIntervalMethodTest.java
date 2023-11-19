package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertIntervalMethodTest {
    static InvertIntervalMethod invertIntervalMethod = new InvertIntervalMethod();
    /** START: checkAndCorrectLimits() **/
    @Test
    public void shouldReturnCorrectedLimitsForALessThanB() {
        int a = 0;
        int b = 1;
        int[] expected = {a, b};
        assertArrayEquals(expected, invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnCorrectedLimitsForBLessThanA() {
        int a = 1;
        int b = 0;
        int[] expected = {b, a};
        assertArrayEquals(expected, invertIntervalMethod.checkBGreaterThanA(a, b));
    }

    @Test
    public void shouldReturnCorrectedLimitsForALessThanB_edgeLimitsWithoutZeros() {
        int a = 1;
        int b = 2;
        int[] expected = {a, b};
        assertArrayEquals(expected, invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnCorrectedLimitsForBLessThanA_edgeLimitsWithoutZeros() {
        int a = 2;
        int b = 1;
        int[] expected = {b, a};
        assertArrayEquals(expected, invertIntervalMethod.checkBGreaterThanA(a, b));
    }

    @Test
    public void shouldReturnArrayWithEqualAandBForEqualLimitsZero() { //passa com < e >= e não devia, para matar a mutação
        int a = 0;
        int b = 0;
        int[] expected = {a, 0};
        assertArrayEquals(expected, invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnArrayWithEqualAandBForEqualLimitsOne() { //passa e não devia, para matar a mutação
        int a = 1;
        int b = 1;
        int[] expected = {a, b};
        assertArrayEquals(expected, invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitAandBLessThanZero() {
        int a = -1;
        int b = -1;
        assertNull(invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitBLessThanZero() {
        int a = 0;
        int b = -1;
        assertNull(invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitALessThanZero() {
        int a = -1;
        int b = 0;
        assertNull(invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForBothLimitsLessThanZero() {
        int a = -1;
        int b = -2;
        assertNull(invertIntervalMethod.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForBothLimitsLessThanZero_invertedLimits() {
        int a = -2;
        int b = -1;
        assertNull(invertIntervalMethod.checkAndCorrectLimits(a, b));
    }
    /** END: checkAndCorrectLimits() **/

    // Both a and b are negative
    @Test
    public void testBothNegative() {
        assertNull(invertIntervalMethod.checkAndCorrectLimits(-1, -2));
    }

    // Either a or b is negative
    @Test
    public void testEitherNegative() {
        assertNull(invertIntervalMethod.checkAndCorrectLimits(-1, 2));
        assertNull(invertIntervalMethod.checkAndCorrectLimits(2, -1));
    }

    // a is less than b
    @Test
    public void testALessThanB() {
        assertArrayEquals(new int[]{1, 2}, invertIntervalMethod.checkAndCorrectLimits(1, 2));
    }

    // a is equal to b
    @Test
    public void testAEqualToB() {
        assertArrayEquals(new int[]{2, 2}, invertIntervalMethod.checkAndCorrectLimits(2, 2));
    }

    // a is greater than b
    @Test
    public void testAGreaterThanB() {
        assertArrayEquals(new int[]{1, 2}, invertIntervalMethod.checkBGreaterThanA(2, 1));
    }

    // a is zero and b is positive
    @Test
    public void testAIsZeroBIsPositive() {
        assertArrayEquals(new int[]{0, 1}, invertIntervalMethod.checkAndCorrectLimits(0, 1));
    }

    // b is zero and a is positive
    @Test
    public void testBIsZeroAIsPositive() {
        assertArrayEquals(new int[]{0, 1}, invertIntervalMethod.checkBGreaterThanA(1, 0));
    }

    @Test
    public void testBIsGreaterThanAIsPositive() {
        assertArrayEquals(new int[]{0, 1}, invertIntervalMethod.checkAGreaterThanB(0, 1));
    }

    @Test
    public void testBIsEqualsAIsPositive() {
        assertNull(invertIntervalMethod.checkBGreaterThanA(0, 0));
    }

    @Test
    public void testBIsEqualsAIsPositiveOne() {
        assertNull(invertIntervalMethod.checkAGreaterThanB(1, 1));
    }

    @Test
    public void testBIsEqualsAIsNegativeOne() {
        assertNull(invertIntervalMethod.checkBGreaterThanA(-1, -1));
    }
}