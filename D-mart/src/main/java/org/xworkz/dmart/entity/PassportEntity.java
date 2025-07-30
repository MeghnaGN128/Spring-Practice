package org.xworkz.dmart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
@Getter
@Setter
@Entity
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Integer id;

    @Column(name = "passport_name")
    private String name;

    @Column(name = "passport_pinode")
    private long pinode;

    @Column(name = "passport_dob")
    private  String dob;

    @Column(name = "passport_address")
    private String address;
}
