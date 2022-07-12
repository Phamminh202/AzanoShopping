package com.example.azanoshop.entity;

import com.example.azanoshop.entity.base.BaseEntity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category{
    @Id
    private String id;
    private String name;
}
