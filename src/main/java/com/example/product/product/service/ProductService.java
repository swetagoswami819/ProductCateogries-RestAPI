package com.example.product.product.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.product.product.DTO.ProductDTO;
import com.example.product.product.entity.Cateogary;
import com.example.product.product.entity.Product;
import com.example.product.product.mapper.ProductMapper;
import com.example.product.product.repository.CateogaryRepository;
import com.example.product.product.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductService {
    
    private ProductRepository productRepository;
    private CateogaryRepository cateogaryRepository;

    /*
     name , description , price , cateogaryId
    */

    //create product
    public ProductDTO createProduct(ProductDTO productDTO){
    Cateogary cateogary = cateogaryRepository.findById(productDTO.getCateogaryId())
    .orElseThrow(()->new RuntimeException("cateogary not found"));

    //DTO -> entity
    Product product = ProductMapper.toProductEntity(productDTO, cateogary);
    productRepository.save(product);

    //entity ->DTO
    return ProductMapper.toProductDTO(product);
    
}

   //get product by id
   public ProductDTO getProductById(Long id){
   Product product =  productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
   return ProductMapper.toProductDTO(product);
   }

   //get All products
   public List<ProductDTO>getAllProducts(){
    return productRepository.findAll().stream().map(ProductMapper :: toProductDTO).toList();
   }

   //update product
   public ProductDTO updateProduct(Long id , ProductDTO productDTO){
    Product existingProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
    
    Cateogary cateogary = cateogaryRepository.findById(productDTO.getCateogaryId()).orElseThrow(()-> new RuntimeException("cateogary not found"));

    existingProduct.setName(productDTO.getName());
    existingProduct.setDescription(productDTO.getDescription());
    existingProduct.setPrice(productDTO.getPrice());
    existingProduct.setCateogary(cateogary);
    productRepository.save(existingProduct);

    return ProductMapper.toProductDTO(existingProduct);

   }

   //delete product
   public String deleteProduct(Long id){
    productRepository.deleteById(id);
    return "product deleted successfully";
   }
}

