package org.cashempire.exception;


public class AuthException extends Exception {
    public String message;

    public AuthException(String message) {
        this.message = message;
    }
}
