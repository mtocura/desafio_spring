package br.com.bootcamp.desafio_spring.dto;

public class ExceptionDTO {
    private String mensagem;

    public ExceptionDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
