package com.example.refactoringworkbook.chapter3.example3;

public class Matcher2 {
    public Matcher2() {}
    public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
        clipLimit(actual, clipLimit);

        if (matchLength(expected, actual)) {
            return false;
        }

        return !isWithinRange(expected, actual, delta);
    }

    private boolean isWithinRange(int[] expected, int[] actual, int delta) {
        for (int i = 0; i < actual.length; i++) {
            if (Math.abs(expected[i] - actual[i]) > delta) {
                return true;
            }
        }
        return false;
    }

    private boolean matchLength(int[] expected, int[] actual) {
        return actual.length != expected.length;
    }

    private void clipLimit(int[] actual, int clipLimit) {
        for (int i = 0; i < actual.length; i++) {
            if (actual[i] > clipLimit) {
                actual[i] = clipLimit;
            }
        }
    }
}
