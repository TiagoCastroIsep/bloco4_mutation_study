package org.example;

public class InvertIntervalMethod {
    public int[] checkAndCorrectLimits(int a, int b) {
        /** not accepting negative limits**/
        if (a < 0 || b < 0) return null;
        else return new int[] {a, b};
    }

    public int[] checkBGreaterThanA(int a, int b) {
        /** not accepting b < a **/
        if (a == b) return null;
        else return new int[] {b, a};
    }

    public int[] checkAGreaterThanB(int a, int b) {
        /** not accepting b < a **/
        if (a == b) return null;
        else return new int[] {a, b};
    }
}
