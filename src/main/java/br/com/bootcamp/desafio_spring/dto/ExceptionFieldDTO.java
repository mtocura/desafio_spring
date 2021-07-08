package br.com.bootcamp.desafio_spring.dto;

public class ExceptionFieldDTO {

    private String field;
    private String message;

    public ExceptionFieldDTO(String message) {
        this.message = message;
    }

    public ExceptionFieldDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getMensagem() {
        return message;
    }
    public String getCampo() {
        return field;
    }
}
