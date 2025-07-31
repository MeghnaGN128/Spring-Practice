package com.xworkz.products.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "cloth_details")
public class ClothEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_id")
    private Integer id;

    @Column(name = "cloth_type")
    private String type;

    @Column(name = "cloth_price")
    private Double price;

    @Column(name = "cloth_brand")
    private String brand;

    @Column(name = "cloth_size")
    private String size;
}
