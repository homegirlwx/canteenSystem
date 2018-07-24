package com.smart.domain;

import java.io.Serializable;

public class Food implements Serializable {
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    private int foodId;

    private String foodName;

    private Double foodPrice;

    public Food(){}

    public Food(String foodName, double foodPrice){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

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

    @Override
    public String toString(){
        return "foodName = " + foodName + " foodPrice" + foodPrice;
    }
}
