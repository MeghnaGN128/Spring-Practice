package com.xworkz.spects.dto;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
@Data
public class SpectDTO {
    private String shape;
    private String brand;
    private String price;
}
