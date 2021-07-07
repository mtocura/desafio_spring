package br.com.bootcamp.desafio_spring.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Exception e) {
        super(e);
    }
}
