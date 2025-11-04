package com.example.cricBuzz_backend.exception;

public class DuplicatePlayerException extends RuntimeException {
    public DuplicatePlayerException(String message) {
        super(message);
    }
}
