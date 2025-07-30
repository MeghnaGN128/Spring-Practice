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
@Table(name = "event_details")
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;

    @Column(name = "participant_name")
    private String participantName;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "registration_date")
    private String registrationDate;

    @Column(name = "contact_number")
    private String contactNumber;
}
