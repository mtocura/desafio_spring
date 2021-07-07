package br.com.bootcamp.desafio_spring.dto;

public class SellerPromoPostsCountDTO {

    private Integer userId;
    private String userName;
    private Integer promoproducts_count;

    public SellerPromoPostsCountDTO(Integer userId, String userName, Integer promoproducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = promoproducts_count;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPromoproducts_count() {
        return promoproducts_count;
    }

    public void setPromoproducts_count(Integer promoproducts_count) {
        this.promoproducts_count = promoproducts_count;
    }
}
