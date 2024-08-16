package com.huuduy.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int productId;

    @Column(name = "product_name")
    String productName;

    @Column(name = "product_img")
    String productImg;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "product_price")
    double productPrice;

    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false, referencedColumnName = "cate_id")
    @JsonBackReference
    Category category;
}
