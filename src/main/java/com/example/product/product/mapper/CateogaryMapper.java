package com.example.product.product.mapper;

import com.example.product.product.entity.Cateogary;
import com.example.product.product.DTO.CateogaryDTO;


public class CateogaryMapper {

    //entity to DTO
    public static CateogaryDTO toCateogaryDTO(Cateogary cateogary){
        if(cateogary==null){
            return null;
        }

        CateogaryDTO cateogaryDTO = new CateogaryDTO();
        cateogaryDTO.setId(cateogary.getId());
        cateogaryDTO.setName(cateogary.getName());
        cateogaryDTO.setProducts(cateogary.getProducts().stream()
        .map(ProductMapper::toProductDTO)
        .toList());
        return cateogaryDTO;
        
    }

    //DTO to entity
    public static Cateogary toCateogaryEntity(CateogaryDTO cateogarydto){
        Cateogary cateogary = new Cateogary();
        cateogary.setName(cateogarydto.getName());
        return cateogary;
    }
    
}
