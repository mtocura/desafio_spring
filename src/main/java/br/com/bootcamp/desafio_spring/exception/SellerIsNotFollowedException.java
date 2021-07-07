package br.com.bootcamp.desafio_spring.exception;

public class SellerIsNotFollowedException extends RuntimeException{

    public SellerIsNotFollowedException() {
    }

    public SellerIsNotFollowedException(String message) {
        super(message);
    }
}
