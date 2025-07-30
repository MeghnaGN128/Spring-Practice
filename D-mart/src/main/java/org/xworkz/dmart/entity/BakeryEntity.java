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
@RequiredArgsConstructor
@ToString
@Table(name="sweets details")
public class BakeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sweets_id")
    private Integer id;

    @Column(name = "sweets_name")
    private String sweetsName;

    @Column(name = "sweets_price")
    private Double price;

    @Column(name = "sweets_mfd")
    private  String mfd;

    @Column(name = "sweets_company")
    private String company;

}
