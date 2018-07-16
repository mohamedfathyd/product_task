package com.example.hp.products_task.model;

import com.google.gson.annotations.SerializedName;

public class contact {
    @SerializedName("productDescription")
         private String productDescription;
    @SerializedName("image")
         private Image  image;
    @SerializedName("price")
         private int price;

    public String getProductDescription() {
        return productDescription;
    }

    public Image getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }
}
