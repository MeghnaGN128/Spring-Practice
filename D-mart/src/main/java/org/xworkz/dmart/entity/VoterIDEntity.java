package org.xworkz.dmart.entity;

public class VoterIDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_mfd")
    private  String mfd;

    @Column(name = "product_company")
    private String company;
}
