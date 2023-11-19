package org.example;

public class CorrectLimits2 {
    public int[] checkAndCorrectLimits(int a, int b) {
        /** not accepting negative limits**/
        if (a < 0 || b < 0) return null;
        if (a < b) return new int[]{a, b, 0};
//        if (a > b) return new int[]{b, a, 1};
        return new int[]{b, a, 2};
    }
}
