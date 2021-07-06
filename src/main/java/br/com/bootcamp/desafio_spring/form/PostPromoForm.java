package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostPromoForm extends PostForm{
    @NotNull
    @NotEmpty
    private boolean hasPromo;

    @NotNull
    @NotEmpty
    private double discount;

    public PostPromoForm() {
    }

    public PostPromoForm(int userId, int postId, Date date, ProductForm detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public double getDiscount() {
        return discount;
    }
}
