package com.huuduy.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    int cateId;

    @Column(name = "cate_name")
    String cateName;

    @Column(name = "cate_description")
    String cateDescription;

    @Column(name = "cate_img")
    String cateImg;
}
