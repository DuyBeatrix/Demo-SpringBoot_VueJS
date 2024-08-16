package com.huuduy.ecommerce.mapper;

import com.huuduy.ecommerce.DTO.request.ProductRequest;
import com.huuduy.ecommerce.DTO.response.ProductResponse;
import com.huuduy.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper
{
    @Mapping(target = "category.cateId", source = "cateId")
    Product toProduct(ProductRequest productRequest);

    @Mapping(target = "cateId", source = "category.cateId")
    ProductResponse toProductResponse(Product product);

    void updateProduct(@MappingTarget Product product, ProductRequest productRequest);
}
