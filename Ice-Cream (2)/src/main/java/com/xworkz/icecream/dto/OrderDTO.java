package com.xworkz.icecream.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String name;
    private String flavour;
    private Integer quantity;
    private Boolean takeAway;
    private String coupon;
    private String AddOns;
}
