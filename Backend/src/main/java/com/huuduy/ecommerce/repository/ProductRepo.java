package com.huuduy.ecommerce.repository;

import com.huuduy.ecommerce.model.Category;
import com.huuduy.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{
    List<Product> findByCategory(Category category);
}
