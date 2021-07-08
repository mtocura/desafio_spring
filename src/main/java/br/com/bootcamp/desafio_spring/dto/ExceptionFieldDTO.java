package br.com.bootcamp.desafio_spring.dto;

public class ExceptionDTO {

    private String campo;
    private String mensagem;

    public ExceptionDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ExceptionDTO(String campo, String mensagem) {
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
