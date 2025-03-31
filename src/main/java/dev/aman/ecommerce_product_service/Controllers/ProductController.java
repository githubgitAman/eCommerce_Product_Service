package dev.aman.ecommerce_product_service.Controllers;

import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import dev.aman.ecommerce_product_service.Models.Product;
import dev.aman.ecommerce_product_service.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{products}")
public class ProductController {

    private ProductService productService;
    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
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
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ProductNotFoundException {
       //Converting Page of products into List of products using getContent method
        Page<Product> products = productService.getAllProducts(pageNumber, pageSize);
       List<Product> productList = products.getContent();
       return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException{
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.replaceProduct(id, product),
                HttpStatus.OK
        );
        return response;
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        ResponseEntity<Product> reponse = new ResponseEntity<>(
                productService.updateProduct(id, product),
                HttpStatus.OK
        );
        return reponse;
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.addProduct(product),
                HttpStatus.CREATED
        );
        return response;
    }

}
