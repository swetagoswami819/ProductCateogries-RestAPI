package com.example.product.product.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
 
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CateogaryDTO {
    private Long id;
    private String name;

    private List<ProductDTO> products;
    
}
