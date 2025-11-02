package com.example.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.product.entity.Cateogary;

@Repository
public interface CateogaryRepository extends JpaRepository<Cateogary, Long> {  
}
