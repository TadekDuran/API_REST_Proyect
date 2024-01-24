package com.application.rest.SpringBootApiRest.controllers.dto;

import com.application.rest.SpringBootApiRest.entities.Product;
import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;
    private String name;
    private List<Product> productList;
}
