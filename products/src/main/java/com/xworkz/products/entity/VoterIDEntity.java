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
@Table(name = "voter_id_details")
public class VoterIDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voter_id")
    private Integer id;

    @Column(name = "voter_name")
    private String name;

    @Column(name = "voter_number")
    private String voterNumber;

    @Column(name = "voter_gender")
    private String gender;

    @Column(name = "voter_age")
    private Integer age;
}
