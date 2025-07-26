package com.xworkz.java.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class CardBoardDTO {
    private String type;
    private int size;
    private String quality;
    private int quantity;
    private String color;


}
