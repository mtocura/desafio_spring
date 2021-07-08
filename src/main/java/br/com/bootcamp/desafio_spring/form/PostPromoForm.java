package br.com.bootcamp.desafio_spring.form;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class PostPromoForm extends PostForm{
    @NotNull(message = "O atributo que indica se a publicação é promocional não pode ser nulo")
    @AssertTrue(message = "O atributo que indica se a publicação é promocional deve ser true")
    private boolean hasPromo;

    @NotNull(message = "O atributo de desconto de um produto não pode ser nulo")
    @Positive(message = "o atributo de desconto de um produto deve ser maior do que 0")
    private double discount;

    @NotNull(message = "A data de expiração não deve ser nula")
    @FutureOrPresent(message = "A data de expiração da promoção deve ser datas futuras ou o dia de hoje")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date expireDate;

    public PostPromoForm() {
    }

    public PostPromoForm(int userId, int postId, Date date, ProductForm detail, int category, double price, boolean hasPromo, double discount, Date expireDate) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
        this.expireDate = expireDate;
    }

    public boolean getHasPromo() {
        return hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public Date getExpireDate() {
        return expireDate;
    }
}
