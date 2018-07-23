package com.smart.domain;

import java.io.Serializable;

public class Food implements Serializable {
    private String foodName;

    private Double foodPrice;

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
