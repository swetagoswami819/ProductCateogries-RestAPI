package com.example.product.product.DTO;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
 
import lombok.NoArgsConstructor;

@Schema(
    name = "Cateogary",
    description = "Data Transfer Object for Cateogary"
)

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CateogaryDTO {
    private Long id;
    private String name;

    private List<ProductDTO> products;
    
}
