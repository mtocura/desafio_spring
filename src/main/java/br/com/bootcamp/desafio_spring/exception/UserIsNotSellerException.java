package br.com.bootcamp.desafio_spring.exception;

public class UserIsNotSellerException extends RuntimeException {
    public UserIsNotSellerException() {
    }

    public UserIsNotSellerException(String message) {
        super(message);
    }
}
