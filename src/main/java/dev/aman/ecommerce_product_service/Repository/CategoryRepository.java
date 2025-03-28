package dev.aman.ecommerce_product_service.Repository;

import dev.aman.ecommerce_product_service.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

}
