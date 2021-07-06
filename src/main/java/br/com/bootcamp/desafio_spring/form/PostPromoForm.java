package br.com.bootcamp.desafio_spring.form;

import java.util.Date;

public class PostPromoForm extends PostForm{
    private boolean hasPromo;
    private double discount;

    public PostPromoForm() {
    }

    public PostPromoForm(int userId, int id_post, Date date, ProductForm detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, id_post, date, detail, category, price);
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
