package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(@Size(min = 5, message="CategoryName must atleast be 5 characters") @NotBlank(message = "Name may not be blank") String categoryName);
}
