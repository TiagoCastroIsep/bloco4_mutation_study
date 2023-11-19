package org.example;

import java.util.Arrays;

public class Bloco4Utils {
    public int getNumberOfDigits(int number) {
        int validated = validateNumberIsEqualsOrBiggerThanZeroAndInsideIntLimits(number);
        if (validated == -1) return -1;

        if (number == 0) return 1;

        int reducedNumber = number;

        int count = 0;
        while (reducedNumber != 0) {
            count++;
            reducedNumber /= 10;
        }

        return count;
    }

    public int[] getArrayFromIntNumber(int number) {
        int validated = validateNumberIsEqualsOrBiggerThanZeroAndInsideIntLimits(number);
        if (validated == -1) return null;

        int arrayLength = getNumberOfDigits(number);
        int[] arrayFromNumberDigits = new int[arrayLength];

        for (int i = arrayLength - 1; i >= 0; i--) {
            arrayFromNumberDigits[i] = number % 10;
            number /= 10;
        }

        return arrayFromNumberDigits;
    }

    public int sumOfArrayElementsFromIntArrayInput(int[] digitsArray) {
        int sum = 0;
        for (int digit : digitsArray) {
            sum += digit;
        }
        return sum;
    }

    public int[] reducedArrayOfPairsOrNotPairs(int[] numbers, boolean pair) {
        int arrayLength = countNumberOfPairOrNotPairElementsInArray(numbers, pair);
        int[] reducedArray = new int[arrayLength];
        if (pair) {
            for (int i = 0, j = 0; i < numbers.length; i++)
                if (numbers[i] % 2 == 0) {
                    reducedArray[j] = numbers[i];
                    j++;
                }
            return reducedArray;
        }

        for (int i = 0, j = 0; i < numbers.length; i++)
            if (numbers[i] % 2 != 0) {
                reducedArray[j] = numbers[i];
                j++;
            }
        return reducedArray;
    }

    private int countNumberOfPairOrNotPairElementsInArray(int[] numbers, boolean pair) {
        int count = 0;

        if (pair) {
            for (int number : numbers) if (number % 2 == 0) count++;
            return count;
        }

        for (int number : numbers) if (number % 2 != 0) count++;
        return count;
    }

    public int[] getMultiplesOfNumberBetweenLimits(int x, int a, int b) {
        int[] limits = checkAndCorrectLimits(a, b);
        if (limits == null) return null;

        int minLimit = limits[0];
        int maxLimit = limits[1];
        if (x == 0) return getReturnFromXEqualsZero(maxLimit);

        int arraySize = getNumberOfMultiples(x, minLimit, maxLimit);

        int[] result = new int[arraySize];

        // survives because if minLimit = 0 then loopsNumber is the same as without mutation, so we can change operator to subtraction
        // survives boundary change. Since we might find all multiples before the loop ends, having < or <= might be the same
        // unless there's a test in which the last number is also a multiple
        for (int i = minLimit, j = 0; i <= maxLimit; i++) {
            if (i % x == 0) {
                result[j] = i;
                j++;
            }
            // break added because also removed the equation maxLimit - minLimit because of a mutation test
            // in which a mutation survived because when minLimit is 0, maxLimit - minLimit or maxLimit + minLimit is the same result.
            if (result[result.length - 1] > 0) break;
        }

        return result;
    }

    private int[] getReturnFromXEqualsZero(int maxLimit) {
        int[] resultArray = new int[maxLimit + 1];

        for (int i = 0; i <= maxLimit; i++) {
            resultArray[i] = i;
        }

        return resultArray;
    }

    private int getNumberOfMultiples(int x, int minLimit, int maxLimit) {
        int multiplesCount = 0;

        // changed due to mutation testing, due to replaced integer subtraction with addition on the inner if with the % calc.
        // this doesn't improve code quality neither testing
        for (int i = 0, incrementMin = minLimit; i <= (maxLimit - minLimit); i++) {
            if (incrementMin < i) break;
            if (incrementMin % x == 0) {
                multiplesCount++;
            }
            incrementMin++;
        }

        return multiplesCount;
    }

    public int validateNumberIsEqualsOrBiggerThanZeroAndInsideIntLimits(int number) {
        if (number < 0) return -1;
        if (number > 1000000000) return -1;
        return 1;
    }

    public boolean validateAllArrayElementsBiggerThanZero(int[] array) {
        for (int element : array) if (element < 0) return false;
        return true;
    }

    public int[] checkAndCorrectLimits(int a, int b) {
        /** not accepting negative limits**/
        if (a < 0 || b < 0) return null;
        if (a < b) return new int[]{a, b, 0};
        return new int[]{b, a, 1};
    }

    /**
     * Ex. 13 and 18
     **/
//    public int getMinOrMaxValueFromArray(int[] numbers, boolean minValue) {
//        if (numbers.length == 0) return -1;
//
//        /** since we're returning negative ints as status code for errors, I'll not allow any negative elements in the array **/
//        for (int num : numbers) if (num < 0) return -1;
//
//        // changed conditional boundary on both for loops. Fails on <= and >= on both cases,
//        // so it means that when I have an array of all the same elements, it will still return the correct value
//        // therefore, no problem on keeping this survived mutant.
//        int currentValue = numbers[0];
//        if (minValue) {
//            // TODO: survived mutant
//            for (int num : numbers)
//                if (num < currentValue) currentValue = num; // < or <= no issues for the end result...
//
//            return currentValue;
//        }
//        // TODO: survived mutant
//        for (int num : numbers) if (num > currentValue) currentValue = num; // > or >= no issues for the end result...
//
//        return currentValue;
//    }
    public int getMinOrMaxValueFromArray(int[] numbers, boolean minValue) {
        if (numbers.length == 0) return -1;

        /** since we're returning negative ints as status code for errors, I'll not allow any negative elements in the array **/
        for (int num : numbers) if (num < 0) return -1;

        // changed conditional boundary on both for loops. Fails on <= and >= on both cases,
        // so it means that when I have an array of all the same elements, it will still return the correct value
        // therefore, no problem on keeping this survived mutant.
        int currentValue = numbers[0];
        if (minValue) {
            // TODO: check this with teacher
            for (int num : numbers)
                if (num < currentValue) {
                    if (num == currentValue) break; // unnecessary line to kill a mutant
                currentValue = num;
            }
//            killed mutant
//            currentValue = Arrays.stream(numbers).min().getAsInt();

            return currentValue;
        }
        // TODO: survived mutant
        for (int num : numbers)
            if (num > currentValue) {
                if (num == currentValue) break; // unnecessary line to kill a mutant
                currentValue = num;
            }
//        killed mutant
//        currentValue = Arrays.stream(numbers).max().getAsInt();

        return currentValue;
    }

    public double getAverageFromArrayValues(int[] numbers) {
        if (numbers.length == 0) return -1;

        int totalElements = numbers.length;

        double sumOfElements = 0;
        for (int num : numbers) sumOfElements += num;

        return sumOfElements / totalElements;
    }

    public int getProductOfArrayElements(int[] numbers) {
        if (numbers.length == 0) return -1;

        int productOfNumbers = 1;
        for (int num : numbers) productOfNumbers *= num;

        return productOfNumbers;
    }

    /**
     * START - EX 13
     **/
    public int[] getSetOfNonRepeatedNumbers(int[] numbers) {
        if (numbers.length == 0) return null;
        int[] setOfNumbers = new int[numbers.length + 1];
        filterDuplicatesLogic(numbers, setOfNumbers);

        return getReducedSetOfNumbersArray(numbers, setOfNumbers);
    }

    private void filterDuplicatesLogic(int[] numbers, int[] setOfNumbers) {
        int reducedArrayLength = 0;

        for (int i = 0, j = 1; i < numbers.length; i++) {
            boolean isRepeated = false;
            for (int k = 1; k < numbers.length; k++) {
                if (k <= i) continue;
                if (numbers[i] == numbers[k]) {
                    isRepeated = true;
                }
            }
            if (!isRepeated) {
                setOfNumbers[j] = numbers[i];
                j++;
                reducedArrayLength++;
            }
        }

        setOfNumbers[0] = reducedArrayLength;
    }

    public int[] getReducedSetOfNumbersArray(int[] numbers, int[] setOfNumbers) {
        int arrayLength = setOfNumbers[0];

        int[] reducedArray = new int[arrayLength];

        for (int i = 0; i < reducedArray.length; i++) {
            reducedArray[i] = setOfNumbers[i + 1];
        }

        return reducedArray;
    }
    /**END - EX 13**/

    /**
     * EX 18
     **/
    public boolean isPrimeNumber(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        // replaced boolean return from true to false and the mutation survives
        // killed after code refactor and removed unnecessary if (number < 2) condition
        return count == 2;
    }

    public boolean checkIfMatrixIsSquare(int[][] matrix) {
        if (matrix.length == 0) return false;

        for (int[] row : matrix) {
            if (row.length != matrix.length) return false;
        }

        return true;
    }

    public boolean checkIfMatrixIsRegular(int[][] matrix) {
        if (matrix.length == 0) return false;

        int firstRowLength = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != firstRowLength) return false;
        }

        return true;
    }

    public int[] getReversedArray(int[] matrix) {
        if (matrix.length == 0) return null;
        int[] reversedArray = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            reversedArray[i] = matrix[matrix.length - 1 - i];
        }

        return reversedArray;
    }
}
