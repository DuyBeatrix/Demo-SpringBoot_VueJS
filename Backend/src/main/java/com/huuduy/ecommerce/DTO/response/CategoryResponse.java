package com.huuduy.ecommerce.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse
{
    int cateId;

    String cateName;

    String cateDescription;

    String cateImg;

    List<ProductResponse> productResponseList;
}
