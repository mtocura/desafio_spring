package br.com.bootcamp.desafio_spring.exception;

public class PostIdAlreadyExistsException extends RuntimeException {

    public PostIdAlreadyExistsException() {
    }

    public PostIdAlreadyExistsException(String message) {
        super(message);
    }
}
