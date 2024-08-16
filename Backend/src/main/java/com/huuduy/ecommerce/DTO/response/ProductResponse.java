package com.huuduy.ecommerce.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse
{
    int productId;

    String productName;

    String productImg;

    String productDescription;

    double productPrice;

    int cateId;
}
