package com.example.product.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.product.product.DTO.CateogaryDTO;
import com.example.product.product.service.CateogaryService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@AllArgsConstructor
@RequestMapping("/api/cateogries")
public class CateogaryController {

    private CateogaryService cateogaryService;

    //create cateogary
    @PostMapping
    public CateogaryDTO createCateogary(@RequestBody CateogaryDTO cateogaryDTO){
        return cateogaryService.createCateogary(cateogaryDTO);
        
    }
    //get cateogary by id
    @GetMapping("/{id}") 
    public CateogaryDTO getCateogaryById(@PathVariable Long id){
        return cateogaryService.getcCateogarybyId(id);
    }

    //get all cateogary
    @GetMapping
    public List<CateogaryDTO> getAllCateogary() {
        return cateogaryService.getAllCateogaries();
    }
    
    //delete cateogary
    @DeleteMapping("/{id}")
    public String deleteCateogary(@PathVariable Long id) {
        return cateogaryService.deleteCateogary(id);
    }
    
    
}
