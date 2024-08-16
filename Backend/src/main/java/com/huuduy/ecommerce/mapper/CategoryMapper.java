package com.huuduy.ecommerce.mapper;

import com.huuduy.ecommerce.DTO.request.CategoryRequest;
import com.huuduy.ecommerce.DTO.response.CategoryResponse;
import com.huuduy.ecommerce.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    Category toCategory(CategoryRequest categoryRequest);
    CategoryResponse toCategoryResponse(Category category);
    void updateCategory(@MappingTarget Category category, CategoryRequest categoryRequest);

}
