package com.example.azanoshop.entity;

import com.example.azanoshop.entity.base.BaseEntity;
import com.example.azanoshop.entity.myenum.ProductStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    private String id;
    private String name;
    private String detail;
    @Column(columnDefinition = "text")
    private String thumbnails;
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
