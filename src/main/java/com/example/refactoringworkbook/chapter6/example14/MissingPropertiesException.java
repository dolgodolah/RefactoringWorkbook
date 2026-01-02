package com.example.refactoringworkbook.chapter6.example14;

public class MissingPropertiesException extends Exception {
    public MissingPropertiesException(String message) {
        super("Missing or invalid property: " + message);
    }
}
