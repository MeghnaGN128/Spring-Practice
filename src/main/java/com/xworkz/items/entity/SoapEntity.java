package com.xworkz.items.entity;
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
@Table(name = "soap_details")
public class SoapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soap_id")
    private Integer id;

    @Column(name = "soap_name")
    private String name;

    @Column(name = "soap_brand")
    private String brand;

    @Column(name = "soap_price")
    private Double price;

    @Column(name = "soap_fragrance")
    private String fragrance;
}
