package br.com.bootcamp.desafio_spring.exception;

import java.io.IOException;

public class DatabaseException extends IOException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Exception e) {
        super(e);
    }
}
