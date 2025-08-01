package com.xworkz.field.entity;
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
@Table(name = "passport_details")

public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Integer id;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "expiry_date")
    private String expiryDate;
}
