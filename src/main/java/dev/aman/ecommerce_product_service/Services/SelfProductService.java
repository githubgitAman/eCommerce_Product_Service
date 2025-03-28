package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import dev.aman.ecommerce_product_service.Models.Category;
import dev.aman.ecommerce_product_service.Models.Product;
import dev.aman.ecommerce_product_service.Repository.CategoryRepository;
import dev.aman.ecommerce_product_service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product addProduct(Product product) {
        Category category = product.getCategory();
        //Getting category first then adding product
        if(category == null) {
            category = categoryRepository.save(category);
            product.setCategory(category);
        }
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product with given id: " + id + " not found");
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product with given id" + productId + " not found");
        Product updatedProduct = optionalProduct.get();
        if(updatedProduct.getTitle() != null)
            updatedProduct.setTitle(product.getTitle());
        if(updatedProduct.getDescription() != null)
            updatedProduct.setDescription(product.getDescription());
        if(updatedProduct.getPrice() != 0.0)
            updatedProduct.setPrice(product.getPrice());
        return productRepository.save(updatedProduct);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product with given id" + productId + " not found");
        Product updatedProduct = optionalProduct.get();
        updatedProduct.setTitle(product.getTitle());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
        productRepository.deleteById(productId);
    }
}
