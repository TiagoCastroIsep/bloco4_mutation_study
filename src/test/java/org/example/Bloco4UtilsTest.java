package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bloco4UtilsTest {
    static final Bloco4Utils bloco4Utils = new Bloco4Utils();
    @Test
    public void shouldReturnCorrectNumberOfDigits_getNumberOfDigits() {
        int number = 123;
        int expected = 3;
        assertEquals(expected, bloco4Utils.getNumberOfDigits(number));
    }

    @Test
    public void shouldReturnCorrectNumberOfDigitsForNumberZero_getNumberOfDigits() {
        int number = 0;
        int expected = 1;
        assertEquals(expected, bloco4Utils.getNumberOfDigits(number));
    }

    @Test
    public void shouldReturnMinus1forNumberLessThanZero_getNumberOfDigits() {
        int number = -1;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getNumberOfDigits(number));
    }

    @Test
    public void shouldReturnMinus1forNumberBiggerThanLimit_getNumberOfDigits() {
        // max number before overflow
        int number = 1000000001;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getNumberOfDigits(number));
    }

    @Test
    public void shouldReturnArrayFromNumber_getArrayFromIntNumber() {
        int number = 123;
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, bloco4Utils.getArrayFromIntNumber(number));
    }

    @Test
    public void shouldReturnArrayWithOneZeroFromNumberZero_getArrayFromIntNumber() {
        int number = 0;
        int[] expected = {0};
        assertArrayEquals(expected, bloco4Utils.getArrayFromIntNumber(number));
    }

    @Test
    public void shouldReturnNullForNumberLessThanZero_getArrayFromIntNumber() {
        int number = -1;
        assertNull(bloco4Utils.getArrayFromIntNumber(number));
    }

    @Test
    public void shouldReturnNullForNumberBiggerThanIntMaxLimit_getArrayFromIntNumber() {
        int number = 1000000001;
        assertNull(bloco4Utils.getArrayFromIntNumber(number));
    }

    @Test
    public void shouldReturnCorrectSum_sumOfArrayElements() {
        int[] digitsArray = {1, 2, 3};
        int expected = 6;
        assertEquals(expected, bloco4Utils.sumOfArrayElementsFromIntArrayInput(digitsArray));
    }

    @Test
    public void shouldReturnCorrectValueForSingleDigitNumber_sumOfArrayElements() {
        int[] digitsArray = {0};
        int expected = 0;
        assertEquals(expected, bloco4Utils.sumOfArrayElementsFromIntArrayInput(digitsArray));
    }

    @Test
    public void shouldReturnMinus1ForNumberLessThanZero_sumOfArrayElements() {
        int[] digitsArray = {-1};
        int expected = -1;
        assertEquals(expected, bloco4Utils.sumOfArrayElementsFromIntArrayInput(digitsArray));
    }

    @Test
    public void shouldReturnReducedArrayOfPairs() {
        int[] number = {3, 6, 7, 8, 1};
        int[] expected = {6, 8};
        assertArrayEquals(expected, bloco4Utils.reducedArrayOfPairsOrNotPairs(number, true));
    }

    @Test
    public void shouldReturnReducedArrayOfNotPairs() {
        int[] number = {3, 6, 7, 8, 1};
        int[] expected = {3, 7, 1};
        assertArrayEquals(expected, bloco4Utils.reducedArrayOfPairsOrNotPairs(number, false));
    }

    /** START: checkAndCorrectLimits() **/
    @Test
    public void shouldReturnCorrectedLimitsForALessThanB() {
        int a = 0;
        int b = 1;
        int[] expected = {a, b, 0};
        assertArrayEquals(expected, bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnCorrectedLimitsForBLessThanA() {
        int a = 1;
        int b = 0;
        int[] expected = {b, a, 1};
        assertArrayEquals(expected, bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnCorrectedLimitsForALessThanB_edgeLimitsWithoutZeros() {
        int a = 1;
        int b = 2;
        int[] expected = {a, b, 0};
        assertArrayEquals(expected, bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnCorrectedLimitsForBLessThanA_edgeLimitsWithoutZeros() {
        int a = 2;
        int b = 1;
        int[] expected = {b, a, 1};
        assertArrayEquals(expected, bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnArrayWithEqualAandBForEqualLimitsZero() { //passa com < e >= e não devia, para matar a mutação
        int a = 0;
        int b = 0;
        int[] expected = {b, a, 1};
        assertArrayEquals(expected, bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnArrayWithEqualAandBForEqualLimitsOne() { //passa e não devia, para matar a mutação
        int a = 1;
        int b = 1;
        int[] expected = {b, a, 1};
        assertArrayEquals(expected, bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitAandBLessThanZero() {
        int a = -1;
        int b = -1;
        assertNull(bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitBLessThanZero() {
        int a = 0;
        int b = -1;
        assertNull(bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForLowerLimitALessThanZero() {
        int a = -1;
        int b = 0;
        assertNull(bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForBothLimitsLessThanZero() {
        int a = -1;
        int b = -2;
        assertNull(bloco4Utils.checkAndCorrectLimits(a, b));
    }

    @Test
    public void shouldReturnNullForBothLimitsLessThanZero_invertedLimits() {
        int a = -2;
        int b = -1;
        assertNull(bloco4Utils.checkAndCorrectLimits(a, b));
    }
    /** END: checkAndCorrectLimits() **/

    @Test
    public void shouldReturnMultiplesOfNBetweenLimits() {
        int x = 3;
        int a = 0;
        int b = 10;
        int[] expected = {0, 3, 6, 9};
        assertArrayEquals(expected, bloco4Utils.getMultiplesOfNumberBetweenLimits(x, a, b));
    }

    //aditional test after mutation testing
    @Test
    public void shouldReturnMultiplesOfNBetweenLimitsWhenMaxNumberIsAMultiple() {
        int x = 2;
        int a = 0;
        int b = 10;
        int[] expected = {0, 2, 4, 6, 8, 10};
        assertArrayEquals(expected, bloco4Utils.getMultiplesOfNumberBetweenLimits(x, a, b));
    }

    //aditional test after mutation testing
    @Test
    public void shouldReturnMultiplesOfNBetweenLimitsWhenMaxNumberIsAMultiple_minNumberIsOne() {
        int x = 2;
        int a = 1;
        int b = 10;
        int[] expected = {2, 4, 6, 8, 10};
        assertArrayEquals(expected, bloco4Utils.getMultiplesOfNumberBetweenLimits(x, a, b));
    }

    //aditional test after mutation testing
    @Test
    public void shouldReturnDiffResultWhenMinLimitIsZero() {
        int x = 2;
        int a = 3;
        int b = 10;
        int[] expected = {4, 6, 8, 10};
        assertArrayEquals(expected, bloco4Utils.getMultiplesOfNumberBetweenLimits(x, a, b));
    }

    @Test
    public void shouldReturnNullForLimitLessThanZero() {
        int x = 3;
        int a = -1;
        int b = 10;
        assertNull(bloco4Utils.getMultiplesOfNumberBetweenLimits(x, a, b));
    }

    @Test
    public void shouldReturnAllNumbersForXEqualsZero() {
        int x = 0;
        int a = 0;
        int b = 3;
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, bloco4Utils.getMultiplesOfNumberBetweenLimits(x, a, b));
    }

    /** START: getMinOrMaxValueFromArray() **/
    @Test
    public void shouldReturnMinValueInIntArray_getMinValueFromArray() {
        int[] numbers = {2, 3, 1, 10, 8};
        boolean minValue = true;
        int expected = 1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    // START: new tests trying to find edgeCases
    @Test
    public void shouldReturnMinValueInIntArray_edgeCase1_getMinValueFromArray() {
        int[] numbers = {2, 3, 1, 10, 0};
        boolean minValue = true;
        int expected = 0;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase2_getMinValueFromArray() {
        int[] numbers = {2, 3, 1, 10, -1};
        boolean minValue = true;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase3_getMinValueFromArray() {
        int[] numbers = {2, 3, 1, 10, 1};
        boolean minValue = true;
        int expected = 1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase4_getMinValueFromArray() {
        int[] numbers = {1, 3, 2, 10, 4};
        boolean minValue = true;
        int expected = 1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase5_getMinValueFromArray() {
        int[] numbers = {1};
        boolean minValue = true;
        int expected = 1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase6_getMinValueFromArray() {
        int[] numbers = {-1, 1};
        boolean minValue = true;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase7_getMinValueFromArray() {
        int[] numbers = {-1};
        boolean minValue = true;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinValueInIntArray_edgeCase8_getMinValueFromArray() {
        int[] numbers = {0};
        boolean minValue = true;
        int expected = 0;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturn2ForAllElementsEquals0_getMinValueFromArray() {
        int[] numbers = {0, 0, 0};
        boolean minValue = true;
        int expected = 0;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturn2ForAllElementsEqualsMinus1_getMinValueFromArray() {
        int[] numbers = {-1, -1, -1};
        boolean minValue = true;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }
    // END: new tests trying to find edgeCases

    @Test
    public void shouldReturnMinus1ForEmptyArray_getMinValueFromArray() {
        int[] numbers = new int[0];
        boolean minValue = true;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturn2ForAllElementsEquals2_getMinValueFromArray() {
        int[] numbers = {2, 2, 2};
        boolean minValue = true;
        int expected = 2;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    // maxValue
    @Test
    public void shouldReturnMaxValueInIntArray_getMaxValueFromArray() {
        int[] numbers = {2, 3, 1, 10, 8};
        boolean minValue = false;
        int expected = 10;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturnMinus1ForEmptyArray_getMaxValueFromArray() {
        int[] numbers = new int[0];
        boolean minValue = false;
        int expected = -1;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }

    @Test
    public void shouldReturn2ForAllElementsEquals2_getMaxValueFromArray() {
        int[] numbers = {2, 2, 2};
        boolean minValue = false;
        int expected = 2;
        assertEquals(expected, bloco4Utils.getMinOrMaxValueFromArray(numbers, minValue));
    }
    /** END: getMinOrMaxValueFromArray() **/
    @Test
    public void shouldReturnAverageForAllArrayElements() {
        int[] numbers = {2, 2, 2};
        double expected = 2;
        assertEquals(expected, bloco4Utils.getAverageFromArrayValues(numbers));
    }

    @Test
    public void shouldReturnMinus1IfNumbersArrayIsLessEqualsZero() {
        int[] numbers = new int[0];
        double expected = -1;
        assertEquals(expected, bloco4Utils.getAverageFromArrayValues(numbers));
    }

    @Test
    public void shouldReturnProductOfArrayElements() {
        int[] numbers = {2, 2, 2};
        int expected = 8;
        assertEquals(expected, bloco4Utils.getProductOfArrayElements(numbers));
    }

    @Test
    public void shouldReturnMinus1IfNumbersArrayIsEmpty() {
        int[] numbers = new int[0];
        int expected = -1;
        assertEquals(expected, bloco4Utils.getProductOfArrayElements(numbers));
    }

    @Test
    public void shouldReturnSetOfNonRepeatedNumbers_getSetOfNonRepeatedNumbersMethod() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, bloco4Utils.getSetOfNonRepeatedNumbers(numbers));
    }

    @Test
    public void shouldReturnNullIfNumbersArrayIsEmpty_getSetOfNonRepeatedNumbersMethod() {
        int[] numbers = new int[0];
        assertNull(bloco4Utils.getSetOfNonRepeatedNumbers(numbers));
    }

    //EX18
    @Test
    public void shouldReturnIsPrimeNumber_isPrimeNumber() {
        int number = 11;
        assertTrue(bloco4Utils.isPrimeNumber(number));
    }

    @Test
    public void shouldReturnIsPrimeNumberForNumber13_isPrimeNumber() {
        int number = 13;
        assertTrue(bloco4Utils.isPrimeNumber(number));
    }

    @Test
    public void shouldReturnIsNotPrimeNumberForMinus1_isPrimeNumber() {
        int number = -1;
        assertFalse(bloco4Utils.isPrimeNumber(number));
    }

    @Test
    public void shouldReturnIsNotPrimeNumberForZero_isPrimeNumber() {
        int number = 0;
        assertFalse(bloco4Utils.isPrimeNumber(number));
    }

    @Test
    public void shouldReturnIsNotPrimeNumber_isPrimeNumber() {
        int number = 1;
        assertFalse(bloco4Utils.isPrimeNumber(number));
    }

    @Test
    public void shouldReturnIsPrimeNumberWhenNumberIsTwo_isPrimeNumber() {
        int number = 2;
        assertTrue(bloco4Utils.isPrimeNumber(number));
    }

    // missing test on validateNumberIsEqualsOrBiggerThanZeroAndInsideIntLimits() found at mutation testing
    @Test
    public void shouldReturnOneWhenNumberIsEqual1000000000() {
        int number = 1000000000;
        int expected = 1;
        assertEquals(expected, bloco4Utils.validateNumberIsEqualsOrBiggerThanZeroAndInsideIntLimits(number));
    }

    @Test
    public void shouldReturnMinusOneWhenNumberIsMoreThan1000000000() {
        int number = 1000000001;
        int expected = -1;
        assertEquals(expected, bloco4Utils.validateNumberIsEqualsOrBiggerThanZeroAndInsideIntLimits(number));
    }

    @Test
    public void shouldReturnTrueForAllElementsInArrayBiggerThanZero() {
        int[] array = {0, 1, 2};
        assertTrue(bloco4Utils.validateAllArrayElementsBiggerThanZero(array));
    }

    @Test
    public void shouldReturnTrueForAllElementsInArrayBiggerThanZeroAndAllElementsEqual() {
        int[] array = {0, 0, 0};
        assertTrue(bloco4Utils.validateAllArrayElementsBiggerThanZero(array));
    }

    @Test
    public void shouldReturnFalseForOneElementInArraySmallerThanZero() {
        int[] array = {0, -1, 2};
        assertFalse(bloco4Utils.validateAllArrayElementsBiggerThanZero(array));
    }

    @Test
    public void shouldReturnFalseForAllElementsInArraySmallerThanZero() {
        int[] array = {-2, -1, -3};
        assertFalse(bloco4Utils.validateAllArrayElementsBiggerThanZero(array));
    }

    @Test
    public void shouldReturnFalseForOneElementInArraySmallerThanZeroAtLastPosition() {
        int[] array = {0, 0, -1};
        assertFalse(bloco4Utils.validateAllArrayElementsBiggerThanZero(array));
    }

    /** matrix is rectangular **/
    @Test
    public void shouldReturnFalseForEmptyMatrix() {
        int[][] matrix = new int[0][0];
        assertFalse(bloco4Utils.checkIfMatrixIsRegular(matrix));
    }

    @Test
    public void shouldReturnTrueForSquareMatrix() {
        int[][] matrix = {
                {1, 2},
                {1, 2}
        };
        assertTrue(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    @Test
    public void shouldReturnFalseForMatrixWithDifferentNumberOfColumns() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2},
                {1, 2, 3, 4}
        };

        assertFalse(bloco4Utils.checkIfMatrixIsRegular(matrix));
    }

    @Test
    public void shouldReturnFalseForMatrixWithDifferentNumberOfColumns_row0Bigger() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {1, 2, 3},
                {1, 2},
        };

        assertFalse(bloco4Utils.checkIfMatrixIsRegular(matrix));
    }

    @Test
    public void shouldReturnTrueForMatrixIsRegular() {
        int[][] matrix = {
                {1, 2},
                {1, 2},
                {1, 2},
        };

        assertTrue(bloco4Utils.checkIfMatrixIsRegular(matrix));
    }

    @Test
    public void shouldReturnTrueForMatrixIsRectangle() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3}
        };
        assertFalse(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    /** matrix is square **/
    @Test
    public void shouldReturnFalseForEmptyMatrix_checkIfMatrixIsSquare() {
        int[][] matrix = new int[0][0];
        assertFalse(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    @Test
    public void shouldReturnFalseForNonSquareMatrix_checkIfMatrixIsSquare() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3}
        };
        assertFalse(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    @Test
    public void shouldReturnFalseForMatrixOfLengthEqualsZero_checkIfMatrixIsSquare() {
        int[][] matrix = {
                {}
        };
        assertFalse(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    @Test
    public void shouldReturnTrueForSquareMatrix_checkIfMatrixIsSquare() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        assertTrue(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    @Test
    public void shouldReturnTrueForSquareMatrixWithOneElement_checkIfMatrixIsSquare() {
        int[][] matrix = {
                {1}
        };
        assertTrue(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    @Test
    public void shouldReturnTrueForSquareMatrixWithTwoElements_checkIfMatrixIsSquare() {
        int[][] matrix = {
                {1, 2},
                {1, 2}
        };
        assertTrue(bloco4Utils.checkIfMatrixIsSquare(matrix));
    }

    /** END - square/rectangular and regular matrix **/

    /** START - reversed array of numbers **/
    @Test
    public void shouldReturnReversedNumbers_getReversedNumbersMethod() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, bloco4Utils.getReversedArray(numbers));
    }

    @Test
    public void shouldReturnNullIfNumbersArrayIsEmpty_getReversedNumbersMethod() {
        int[] numbers = new int[0];
        assertNull(bloco4Utils.getReversedArray(numbers));
    }
    /** END - reversed array of numbers **/
}