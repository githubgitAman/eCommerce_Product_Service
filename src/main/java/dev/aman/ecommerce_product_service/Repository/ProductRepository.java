package dev.aman.ecommerce_product_service.Repository;

import dev.aman.ecommerce_product_service.Models.Product;
import dev.aman.ecommerce_product_service.Projections.ProductWithGivenIdAndTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//Here First parameter is the thing on which we are working and Long is the data type of Primary key
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Save method is default so no need to create externally
    Optional<Product> findById(Long id);
    Page<Product> findAll(Pageable pageable);
    void deleteById(Long id);

    //Implementing HQL queries
    @Query("select p.id as id , p.title as title from Product p where p.id = : x")
    ProductWithGivenIdAndTitle randomSearchMethod(Long x);

    //Can also write Native Queries but not used much
    @Query(value = "select P.id as id, P.title as title from Product p where p.id = :y", nativeQuery = true)
    Product randomSearchMethod2(Long y);
}
