package br.com.java.application.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
