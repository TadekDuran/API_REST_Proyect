package com.application.rest.SpringBootApiRest.controllers.dto;

import com.application.rest.SpringBootApiRest.entities.Maker;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    
    private Long id;
    private String name;
    private Double price;
    private Maker maker;
    
}
