package br.com.bootcamp.desafio_spring.dto;

public class ExceptionFieldDTO {

    private String campo;
    private String mensagem;

    public ExceptionFieldDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ExceptionFieldDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
    public String getCampo() {
        return campo;
    }
}
