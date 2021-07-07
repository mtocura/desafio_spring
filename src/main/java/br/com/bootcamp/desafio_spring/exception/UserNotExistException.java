package br.com.bootcamp.desafio_spring.exception;

public class UserNotExistException extends RuntimeException{

    public UserNotExistException(String message) {
        super(message);
    }

    public UserNotExistException(Exception e) {
        super(e);
    }
}
