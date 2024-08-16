package com.huuduy.ecommerce.DTO.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest
{
    String cateName;

    String cateDescription;

    String cateImg;
}
