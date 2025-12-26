package com.example.refactoringworkbook.chapter3.example3;

public class Matcher {
    public Matcher() {}
    public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
        // 너무 긴 값은 잘라낸다.
        for (int i = 0; i < actual.length; i++) {
            if (actual[i] > clipLimit) {
                actual[i] = clipLimit;
            }
        }

        // 길이가 다른지 검사한다.
        if (actual.length != expected.length) {
            return false;
        }

        // 각 항목이 expected +/- delta 내에 있는지 검사한다.
        for (int i = 0; i < actual.length; i++) {
            if (Math.abs(expected[i] - actual[i]) > delta) {
                return false;
            }
        }

        return true;
    }
}
