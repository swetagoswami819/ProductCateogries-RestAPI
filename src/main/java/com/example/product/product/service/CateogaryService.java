package com.example.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.product.DTO.CateogaryDTO;
import com.example.product.product.entity.Cateogary;
import com.example.product.product.mapper.CateogaryMapper;
import com.example.product.product.repository.CateogaryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CateogaryService {

    private CateogaryRepository cateogaryRepository;
    //create cateogary
    public CateogaryDTO createCateogary(CateogaryDTO cateogaryDTO){
        Cateogary cateogary = CateogaryMapper.toCateogaryEntity(cateogaryDTO);
        cateogaryRepository.save(cateogary);
        return CateogaryMapper.toCateogaryDTO(cateogary);
    }

    //get All catoegries
    public List<CateogaryDTO> getAllCateogaries(){
        return cateogaryRepository.findAll().stream().map(CateogaryMapper::toCateogaryDTO).toList();
    }

    //get cateogary by id
    
    public CateogaryDTO getcCateogarybyId(Long id){
        Cateogary cateogary = cateogaryRepository.findById(id).orElseThrow(()->new RuntimeException("catoegary not found"));
        return CateogaryMapper.toCateogaryDTO(cateogary);
    }

    //delete cateogary
    public String deleteCateogary(Long id){
        cateogaryRepository.deleteById(id);
        return "cateogary deleted successfully";
    }


    
}
