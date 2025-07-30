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
@Table(name = "footware_details")
public class FootwareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "footware_id")
    private Integer id;

    @Column(name = "footware_type")
    private String type;

    @Column(name = "footware_brand")
    private String brand;

    @Column(name = "footware_size")
    private String size;

    @Column(name = "footware_price")
    private Double price;
}
