package org.xworkz.dmart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@Table(name="chocolate details ")
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
