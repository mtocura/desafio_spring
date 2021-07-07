package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public class PostPromoForm extends PostForm{
    @NotNull(message = "O atributo que indica se a publicação é promocional não pode ser nulo")
    @AssertTrue(message = "O atributo que indica se a publicação é promocional deve ser true")
    private boolean hasPromo;

    @NotNull(message = "O atributo de desconto de um produto não pode ser nulo")
    @Positive(message = "o atributo de desconto de um produto deve ser maior do que 0")
    private double discount;

    public PostPromoForm() {
    }

    public PostPromoForm(int userId, int postId, Date date, ProductForm detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public boolean getHasPromo() {
        return hasPromo;
    }

    public double getDiscount() {
        return discount;
    }
}
