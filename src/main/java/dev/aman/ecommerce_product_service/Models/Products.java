package dev.aman.ecommerce_product_service.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products extends BaseModel {

    private String title;
    private double price;
    private String description;
    private Category category;
    private String imageUrl;
}
