package com.example.refactoringworkbook.chapter3.example3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatcherTest {

    @Test
    public void testMatch() {
        Matcher matcher = new Matcher();
        int[] expected = new int[] {10, 50, 30, 98};
        int clipLimit = 100;
        int delta = 5;

        int[] actual = new int[] {12, 55, 25, 110};

        assertTrue(matcher.match(expected, actual, clipLimit, delta));

        actual = new int[] {10, 60, 30, 98};
        assertFalse(matcher.match(expected, actual, clipLimit, delta));
        actual = new int[] {10, 50, 30};
        assertFalse(matcher.match(expected, actual, clipLimit, delta));
    }

    @Test
    public void testMatch2() {
        Matcher2 matcher = new Matcher2();
        int[] expected = new int[] {10, 50, 30, 98};
        int clipLimit = 100;
        int delta = 5;

        int[] actual = new int[] {12, 55, 25, 110};

        assertTrue(matcher.match(expected, actual, clipLimit, delta));

        actual = new int[] {10, 60, 30, 98};
        assertFalse(matcher.match(expected, actual, clipLimit, delta));
        actual = new int[] {10, 50, 30};
        assertFalse(matcher.match(expected, actual, clipLimit, delta));
    }
}