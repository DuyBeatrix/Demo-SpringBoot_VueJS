package com.huuduy.ecommerce.controller;

import com.huuduy.ecommerce.DTO.request.ProductRequest;
import com.huuduy.ecommerce.DTO.response.ProductResponse;
import com.huuduy.ecommerce.config.ApiResponse;
import com.huuduy.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> createProduct(@RequestBody ProductRequest productRequest)
    {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(productRequest));
        apiResponse.setCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAllProduct()
    {
        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProduct());
        apiResponse.setCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

    @PutMapping("/{productId}")
    public ApiResponse<ProductResponse> updateProduct(@PathVariable int productId, @RequestBody ProductRequest productRequest)
    {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(productId, productRequest));
        apiResponse.setCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

    @GetMapping("/{cateId}")
    public ApiResponse<List<ProductResponse>> getProductsByCategory(@PathVariable int cateId)
    {
        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getProductsByCategory(cateId));
        apiResponse.setCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

}
