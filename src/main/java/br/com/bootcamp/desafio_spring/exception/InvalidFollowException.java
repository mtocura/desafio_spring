package br.com.bootcamp.desafio_spring.exception;

public class InvalidFollowException extends RuntimeException {
    public InvalidFollowException() {
    }

    public InvalidFollowException(String message) {
        super(message);
    }
}
