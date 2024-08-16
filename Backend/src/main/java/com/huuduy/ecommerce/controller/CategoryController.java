package com.huuduy.ecommerce.controller;

import com.huuduy.ecommerce.DTO.request.CategoryRequest;
import com.huuduy.ecommerce.DTO.response.CategoryResponse;
import com.huuduy.ecommerce.config.ApiResponse;
import com.huuduy.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest)
    {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.createCategory(categoryRequest));
        apiResponse.setMessage("Success");
        apiResponse.setCode(200);
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAllCategories()
    {
        ApiResponse<List<CategoryResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.getAllCategory());
        apiResponse.setMessage("Success");
        apiResponse.setCode(200);
        return apiResponse;
    }

    @PutMapping("/{categoryId}")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable int categoryId, @RequestBody CategoryRequest categoryRequest)
    {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.updateCategory(categoryId, categoryRequest));
        apiResponse.setMessage("Success");
        apiResponse.setCode(200);
        return apiResponse;
    }
}
