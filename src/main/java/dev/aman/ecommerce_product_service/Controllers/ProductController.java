package dev.aman.ecommerce_product_service.Controllers;

import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import dev.aman.ecommerce_product_service.Models.Product;
import dev.aman.ecommerce_product_service.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{products}")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> response = new ResponseEntity<>(
         productService.getProduct(id),
                HttpStatus.OK);
        return response;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
        return response;
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
        productService.deleteProduct(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.replaceProduct(id, product),
                HttpStatus.OK
        );
        return response;
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        ResponseEntity<Product> reponse = new ResponseEntity<>(
                productService.updateProduct(id, product),
                HttpStatus.OK
        );
        return reponse;
    }

}
