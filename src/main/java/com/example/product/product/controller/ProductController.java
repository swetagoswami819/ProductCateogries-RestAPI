package com.example.product.product.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.product.DTO.ProductDTO;
import com.example.product.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Tag(
    name = "Product REST API CRUD Operations",
    description = "CRUD operations for REST API"
)

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    //create product

    private ProductService productService;
    

    @Operation(
        summary = "Create Product",
        description = "Create a new product with the provided details"
    )
    @ApiResponse(
        responseCode = "201",
        description = "Product created successfully"
    )
    //create product 
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createdProduct =  productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Get All Products",
        description = "Retrieve a list of all products"

    )
    //get All products
    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
        
    }


    @Operation(
        summary = "Get Product by ID",
        description = "Retrieve a product by its unique ID"
    )
    //get product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @Operation(
        summary = "Update Product",
        description = "Update an existing product with the provided details"
    )
    //update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id  , @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }
    
    @Operation(
        summary = "Delete Product",
        description = "Delete a product by its unique ID"
    )
    //delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    
    
}
