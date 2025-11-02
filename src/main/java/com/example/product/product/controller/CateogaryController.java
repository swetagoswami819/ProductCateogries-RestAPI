package com.example.product.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.product.product.DTO.CateogaryDTO;
import com.example.product.product.service.CateogaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(
    name = "Cateogary REST API CRUD Operations",
    description = "CRUD operations for REST API"
)


@RestController
@AllArgsConstructor
@RequestMapping("/api/cateogries")
public class CateogaryController {

    private CateogaryService cateogaryService;

    @Operation(
        summary = "Create Cateogary",
        description = "Create a new cateogary with the provided details"
    )
    @ApiResponse(
        responseCode = "201",
        description = "Cateogary created successfully"
    )
    //create cateogary
    @PostMapping
    public CateogaryDTO createCateogary(@RequestBody CateogaryDTO cateogaryDTO){
        return cateogaryService.createCateogary(cateogaryDTO);
        
    }

    @Operation(
        summary = "Get Cateogary by ID",
        description = "Retrieve a cateogary by its unique ID"
    )
    //get cateogary by id
    @GetMapping("/{id}") 
    public CateogaryDTO getCateogaryById(@PathVariable Long id){
        return cateogaryService.getcCateogarybyId(id);
    }

    @Operation(
        summary = "Get All Cateogaries",
        description = "Retrieve a list of all cateogaries"
    )
    //get all cateogary
    @GetMapping
    public List<CateogaryDTO> getAllCateogary() {
        return cateogaryService.getAllCateogaries();
    }
    
    @Operation(
        summary = "Delete Cateogary",
        description = "Delete an existing cateogary with the provided details"
    )
    //delete cateogary
    @DeleteMapping("/{id}")
    public String deleteCateogary(@PathVariable Long id) {
        return cateogaryService.deleteCateogary(id);
    }
    
    
}
