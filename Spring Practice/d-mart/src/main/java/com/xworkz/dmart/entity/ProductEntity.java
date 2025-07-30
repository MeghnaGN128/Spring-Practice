package com.xworkz.dmart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "product_info")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="product_id")
    private Integer product_id;

    @Column(name="product_name")
    private String product_name;

    @Column(name="product_price")
    private double product_price;

    @Column(name="product_mdf")
    private String mdf;

    @Column(name="product_company")
    private String company;

}
