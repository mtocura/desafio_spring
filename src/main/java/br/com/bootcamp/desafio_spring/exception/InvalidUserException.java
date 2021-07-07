package br.com.bootcamp.desafio_spring.exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String message) {
        super(message);
    }

    public InvalidUserException(Exception e) {
        super(e);
    }
}
