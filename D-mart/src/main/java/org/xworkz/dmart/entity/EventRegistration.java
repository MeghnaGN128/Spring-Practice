package org.xworkz.dmart.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="event details")
public class EventRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_budget")
    private Double budget;

    @Column(name = "event_date")
    private  String date;

    @Column(name = "event_company")
    private String company;
}
