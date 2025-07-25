package com.xworkz.java.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RollerDTO {
    private String brand;
    private String color;
    private double price;
    private boolean softGrip;
    private String material;
}
