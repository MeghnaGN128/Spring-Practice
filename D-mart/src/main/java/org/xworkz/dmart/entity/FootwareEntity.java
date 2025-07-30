package org.xworkz.dmart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="footware details")
public class FootwareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "footware_id")
    private Integer id;

    @Column(name = "footware_name")
    private String footwareName;

    @Column(name = "footware_price")
    private Double price;

    @Column(name = "footware_mfd")
    private  String mfd;

    @Column(name = "footware_company")
    private String company;
}
