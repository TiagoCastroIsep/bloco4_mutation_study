package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectLimits2Test {
    static CorrectLimits2 correctLimits2 = new CorrectLimits2();
    /** START: checkAndCorrectLimits() **/
    @Test
    public void shouldReturnCorrectedLimitsForALessThanB() {
        int a = 0;
        int b = 1;
        int[] expected = {a, b, 0};
        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
    }

//    @Test
//    public void shouldReturnCorrectedLimitsForBLessThanA() {
//        int a = 1;
//        int b = 0;
//        int[] expected = {b, a, 1};
//        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
//    }
@Test
public void shouldReturnCorrectedLimitsForBLessThanA() {
    int a = 1;
    int b = 0;
    int[] expected = {b, a, 2};
    assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
}

    @Test
    public void shouldReturnCorrectedLimitsForALessThanB_edgeLimitsWithoutZeros() {
        int a = 1;
        int b = 2;
        int[] expected = {a, b, 0};
        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
    }

//    @Test
//    public void shouldReturnCorrectedLimitsForBLessThanA_edgeLimitsWithoutZeros() {
//        int a = 2;
//        int b = 1;
//        int[] expected = {b, a, 1};
//        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
//    }

    @Test
    public void shouldReturnCorrectedLimitsForBLessThanA_edgeLimitsWithoutZeros() {
        int a = 2;
        int b = 1;
        int[] expected = {b, a, 2};
        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnArrayWithEqualAandBForEqualLimitsZero() {
        int a = 0;
        int b = 0;
        /** deixar a e b invertidos de propósito, mata na mesma o mutante **/
        int[] expected = {a, b, 2};
        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnArrayWithEqualAandBForEqualLimitsOne() {
        int a = 1;
        int b = 1;
        /** deixar a e b invertidos de propósito, mata na mesma o mutante **/
        int[] expected = {a, b, 2};
        assertArrayEquals(expected, correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitAandBLessThanZero() {
        int a = -1;
        int b = -1;
        assertNull(correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitBLessThanZero() {
        int a = 0;
        int b = -1;
        assertNull(correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitALessThanZero() {
        int a = -1;
        int b = 0;
        assertNull(correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForBothLimitsLessThanZero() {
        int a = -1;
        int b = -2;
        assertNull(correctLimits2.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForBothLimitsLessThanZero_invertedLimits() {
        int a = -2;
        int b = -1;
        assertNull(correctLimits2.checkAndCorrectLimits(a, b));
    }
    /** END: checkAndCorrectLimits() **/
}