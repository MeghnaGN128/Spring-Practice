package com.xworkz.products.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="chocolate_details")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ChocolateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Chocolate_id")
    private Integer id;

    @Column(name = "Chocolate_name")
    private String chocolateName;

    @Column(name = "Chocolate_price")
    private Double price;

    @Column(name = "Chocolate_mfd")
    private  String mfd;

    @Column(name = "Chocolate_company")
    private String company;
}
