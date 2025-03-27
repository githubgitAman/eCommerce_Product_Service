package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Confriguations.RestTemplateConfigurations;
import dev.aman.ecommerce_product_service.DTOs.FakeStoreProductDTOs;
import dev.aman.ecommerce_product_service.Models.Category;
import dev.aman.ecommerce_product_service.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProduct(Long id) {
        //Storing returned data into DTOs classes
        FakeStoreProductDTOs fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + id, FakeStoreProductDTOs.class);
        return convertDTOsToProduct(fakeStoreProductDtos);
    }

    @Override
    public List<Product> getAllProducts() {

        //List<FakeStoreProductDTOs> listOfFakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products", List<FakeStoreProductDTOs>.class);
        //Here because of Type Erasure we cannot store it in FakeStoreProductDTOs list as at run time everything is type object
        //so we are using arrays as they are free from Generics
        FakeStoreProductDTOs[] listOfFakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTOs[].class);
        //Converting array of fakeStoreProductDtos to Product list
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTOs fakeStoreProductDtos : listOfFakeStoreProductDto){
            products.add(convertDTOsToProduct(fakeStoreProductDtos));
        }
        return products;
    }

    //Converting DTOs to Product
    private Product convertDTOsToProduct(FakeStoreProductDTOs fakeStoreProductDTOs) {
        Product product = new Product();
        product.setId(fakeStoreProductDTOs.getId());
        product.setTitle(fakeStoreProductDTOs.getTitle());
        product.setDescription(fakeStoreProductDTOs.getDescription());
        product.setPrice(fakeStoreProductDTOs.getPrice());
        //In our class Category is a class whereas in FakeStore it is String
        Category category = new Category();
        category.setDescription(fakeStoreProductDTOs.getCategory());
        product.setCategory(category);
        return product;
    }

}
