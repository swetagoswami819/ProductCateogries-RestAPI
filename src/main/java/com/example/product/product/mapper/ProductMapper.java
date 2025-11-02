package com.example.product.product.mapper;

import com.example.product.product.DTO.ProductDTO;
import com.example.product.product.entity.Cateogary;
import com.example.product.product.entity.Product;

public class ProductMapper {

    //entity to DTO
    public static ProductDTO toProductDTO(Product product){
        if(product==null){
            return null;
        }
        return new ProductDTO (
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getCateogary().getId()
        );
     
    }

    //DTO to entity

    public static Product toProductEntity(ProductDTO productDTO , Cateogary cateogary){
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCateogary(cateogary);
        return product;
    }
    
}
