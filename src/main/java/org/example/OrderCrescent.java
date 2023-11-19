package org.example;

public class OrderCrescent {
    /**
     * original
     **/
//    public static int[] orderCrescent(int[] vector) {
//        int temp;
//
//        for (int i = vector.length - 1; i >= 1; i--) {
//            for (int j = 0; j < i; j++) {
//                if (vector[j] > vector[j + 1]) { // this mutant persists because it is the same in this
//                    // function to be > or >=, nevertheless > is more eficient.
//                    temp = vector[j];
//                    vector[j] = vector[j + 1];
//                    vector[j + 1] = temp;
//                }
//            }
//        }
//
//        return vector;
//    }

//    public int[] orderCrescent(int[] vector) {
//        // test crescentEmpty()
//        if (vector.length == 0) return new int[0];
//
//        return Arrays.stream(vector).sorted().toArray();
//    }
    public int[] orderCrescent(int[] vector) {
        int temp;

        for (int i = vector.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (vector[j] > vector[j + 1]) {
                    // Tiago Castro: Se encontra um valor igual faz bypass ao restante código,
                    // não afeta testes nem resultado final esperado
                    if (vector[j] == vector[j + 1]) break;
                    temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }

        return vector;
    }
}
