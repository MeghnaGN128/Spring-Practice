package org.xworkz.dmart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="cloths details")
public class ClothEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloths_id")
    private Integer id;

    @Column(name = "cloths_name")
    private String clothsName;

    @Column(name = "cloths_price")
    private Double price;

    @Column(name = "cloths_mfd")
    private  String mfd;

    @Column(name = "cloths_company")
    private String company;
}
