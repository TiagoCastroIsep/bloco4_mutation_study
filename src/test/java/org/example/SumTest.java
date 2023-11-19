package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {

    static final Sum sumClass = new Sum();

    @Test
    public void test1() {
        assertEquals(-1, sumClass.sum(-1));
    }

    @Test
    public void test2() {
        assertEquals(-1, sumClass.sum(21));
    }

    @Test
    public void test3() {
        assertEquals(0, sumClass.sum(0));
    }

    @Test
    public void test4() {
        assertEquals(0, sumClass.sum(20));
    }
}