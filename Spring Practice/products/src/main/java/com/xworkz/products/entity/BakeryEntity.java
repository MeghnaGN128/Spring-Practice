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
@Table(name="sweets_details")
public class BakeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sweets_id")
    private Integer id;

    @Column(name = "sweets_name")
    private String SweetName;

    @Column(name = "sweets_price")
    private Double price;

    @Column(name = "sweets_mfd")
    private  String mfd;

    @Column(name = "sweets_company")
    private String company;
}
