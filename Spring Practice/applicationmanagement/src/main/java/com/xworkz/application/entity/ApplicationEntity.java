package com.xworkz.application.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@ToString
@Setter
@Getter
@RequiredArgsConstructor
@Table(name="application_info")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private Integer applicationId;

    @Column(name="application_name")
    private String applicationName;

    @Column(name="application_size")
    private  String applicationSize;

    @Column(name="application_company")
    private String company;

    @Column(name="application_no_of_users")
    private Integer noOfUsers;

    @Column(name="application_ratings")
    private Float ratings;

    @Column(name="application_launch_date")
    private LocalDate launchDate;
}
