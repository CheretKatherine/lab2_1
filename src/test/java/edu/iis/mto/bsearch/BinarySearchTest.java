package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    private static final int NOT_FOUND = -1;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test() {

        int[] seq = {20};

        //test1
        SearchResult bs = BinarySearch.search(20, seq);
        assertTrue(bs.isFound());
        assertEquals(0, bs.getPosition());

        //test2
        bs = BinarySearch.search(4, seq);
        assertFalse(bs.isFound());
        assertEquals(NOT_FOUND, bs.getPosition());

        int[] seq2 = {-4, 0, 6, 34, 46, 689, 1234};

        //test3
        bs = BinarySearch.search(-4, seq2);
        assertTrue(bs.isFound());
        assertEquals(0, bs.getPosition());

        //test4
        bs = BinarySearch.search(1234, seq2);
        assertTrue(bs.isFound());
        assertEquals(seq2.length-1, bs.getPosition());

        //test5
        bs = BinarySearch.search(34, seq2);
        assertTrue(bs.isFound());
        assertEquals(seq2.length/2, bs.getPosition());

        //test6
        bs = BinarySearch.search(1, seq2);
        assertFalse(bs.isFound());
        assertEquals(NOT_FOUND, bs.getPosition());
    }

}
