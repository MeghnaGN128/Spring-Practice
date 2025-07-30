package com.xworkz.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetcareDTO {
    private String name;
    private int id;
    private String location;
    private boolean hasservice;
}
