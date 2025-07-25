package com.xworkz.java.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class BucketDTO {
    private String material;
    private String color;
    private double capacityInLiters;
    private double price;
    private boolean hasHandle;

}
