package br.com.bootcamp.desafio_spring.dto;

public class ExceptionDTO {
    private String message;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public String getMenssage() {
        return message;
    }
}
