package com.huuduy.ecommerce.service;

import com.huuduy.ecommerce.DTO.request.CategoryRequest;
import com.huuduy.ecommerce.DTO.response.CategoryResponse;
import com.huuduy.ecommerce.mapper.CategoryMapper;
import com.huuduy.ecommerce.model.Category;
import com.huuduy.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryRequest categoryRequest)
    {
        Category category = categoryMapper.toCategory(categoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepo.save(category));
    }

    public List<CategoryResponse> getAllCategory()
    {
        List<Category> categoryList = categoryRepo.findAll();
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        for(Category category : categoryList)
        {
            categoryResponseList.add(categoryMapper.toCategoryResponse(category));
        }
        return categoryResponseList;
    }

    public CategoryResponse updateCategory(int categoryId, CategoryRequest categoryRequest)
    {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryMapper.updateCategory(category, categoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepo.save(category));
    }


}
