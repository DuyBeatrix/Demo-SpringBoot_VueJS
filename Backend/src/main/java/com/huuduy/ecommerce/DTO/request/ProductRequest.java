package com.huuduy.ecommerce.DTO.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest
{
    String productName;

    String productImg;

    String productDescription;

    double productPrice;

    int cateId;
}
