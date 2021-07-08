package br.com.bootcamp.desafio_spring.form;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;

public class PostPromoForm extends PostForm{
    @NotNull(message = "O atributo que indica se a publicação é promocional não pode ser nulo")
    @AssertTrue(message = "O atributo que indica se a publicação é promocional deve ser true")
    private boolean hasPromo;

    @NotNull(message = "O atributo de desconto de um produto não pode ser nulo")
    @Positive(message = "o atributo de desconto de um produto deve ser maior do que 0")
    private double discount;

    @NotEmpty(message = "A data da promoção não pode ser vazio ou nulo")
    @NotBlank(message = "A data da promoção não pode ser espaços em branco ou nulo")
    @PastOrPresent(message = "A data da promoção deve ser datas passadas ou o dia de hoje")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private ZonedDateTime expireDate;

    public PostPromoForm() {
    }

    public PostPromoForm(int userId, int postId, ZonedDateTime date, ProductForm detail, int category, double price, boolean hasPromo, double discount, ZonedDateTime expireDate) {
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

    public ZonedDateTime getExpireDate() {
        return expireDate;
    }
}
