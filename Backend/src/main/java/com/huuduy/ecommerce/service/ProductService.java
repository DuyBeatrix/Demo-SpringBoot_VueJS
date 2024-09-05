package com.huuduy.ecommerce.service;

import com.huuduy.ecommerce.DTO.request.ProductRequest;
import com.huuduy.ecommerce.DTO.response.ProductResponse;
import com.huuduy.ecommerce.mapper.ProductMapper;
import com.huuduy.ecommerce.model.Category;
import com.huuduy.ecommerce.model.Product;
import com.huuduy.ecommerce.repository.CategoryRepo;
import com.huuduy.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryRepo categoryRepo;

    public ProductResponse createProduct(ProductRequest productRequest)
    {
        categoryRepo.findById(productRequest.getCateId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productMapper.toProduct(productRequest);
        return productMapper.toProductResponse(productRepo.save(product));
    }

    public List<ProductResponse> getAllProduct()
    {
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product : products) {
            productResponses.add(productMapper.toProductResponse(product));
        }
        return productResponses;
    }

    public ProductResponse updateProduct(int productId, ProductRequest productRequest)
    {
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        productMapper.updateProduct(product, productRequest);
        return productMapper.toProductResponse(productRepo.save(product));
    }

    public List<ProductResponse> getProductsByCategory(int categoryId)
    {
        List<Product> productList = new ArrayList<>();
        Category category = categoryRepo.findById(categoryId).orElseThrow();
        productList = productRepo.findByCategory(category);
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product : productList) {
            productResponses.add(productMapper.toProductResponse(product));
        }
        return productResponses;
    }
}
