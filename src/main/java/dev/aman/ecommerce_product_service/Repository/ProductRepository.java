package dev.aman.ecommerce_product_service.Repository;

import dev.aman.ecommerce_product_service.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Here First parameter is the thing on which we are working and Long is the data type of Primary key
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Save method is default so no need to create externally
    Optional<Product> findById(long id);
    List<Product> findAll();
    void deleteById(long id);
}
