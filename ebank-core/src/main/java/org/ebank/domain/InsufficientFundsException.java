package org.ebank.domain;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
    }

    public InsufficientFundsException(String s) {
        super(s);
    }

    public InsufficientFundsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InsufficientFundsException(Throwable throwable) {
        super(throwable);
    }
}
