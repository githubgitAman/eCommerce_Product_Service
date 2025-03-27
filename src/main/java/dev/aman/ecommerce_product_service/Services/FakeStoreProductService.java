package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.DTOs.FakeStoreProductDTOs;
import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import dev.aman.ecommerce_product_service.Models.Category;
import dev.aman.ecommerce_product_service.Models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
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
    public Product getProduct(Long productId) throws ProductNotFoundException {
        //Calling FakeStore to get product with given Id
        //Storing returned data into DTOs classes
        FakeStoreProductDTOs fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId, FakeStoreProductDTOs.class);
        if(fakeStoreProductDtos == null)
            throw new ProductNotFoundException("Product Not Found, please enter a valid product Id");
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

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        //Our put method of restTemplate is returning void, also put is using execute method that has a return type so we are using that
        //Below first statement is our request i.e the product and second is requestType i.e the output from the FakeStore application
        //We are calling these methods on restTemplate
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTOs.class);
        HttpMessageConverterExtractor<FakeStoreProductDTOs> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTOs.class, restTemplate.getMessageConverters());
        FakeStoreProductDTOs fakeStoreProductDtos =  restTemplate.execute("https://fakestoreapi.com/products/" + productId, HttpMethod.PATCH, requestCallback, responseExtractor);
        return convertDTOsToProduct(fakeStoreProductDtos);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTOs.class);
        HttpMessageConverterExtractor<FakeStoreProductDTOs> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTOs.class, restTemplate.getMessageConverters());
        FakeStoreProductDTOs fakeStoreProductDtos =  restTemplate.execute("https://fakestoreapi.com/products/" + productId, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertDTOsToProduct(fakeStoreProductDtos);
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
