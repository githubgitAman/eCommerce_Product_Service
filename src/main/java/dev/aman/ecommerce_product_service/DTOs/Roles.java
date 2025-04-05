package dev.aman.ecommerce_product_service.DTOs;

import jakarta.persistence.Entity;

public class Roles {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
