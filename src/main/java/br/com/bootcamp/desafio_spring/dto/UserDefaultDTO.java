package br.com.bootcamp.desafio_spring.dto;

public class UserDTO {
    private Integer id;

    //private String name;
    //private List<SellerDTO> following;

    public UserDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
