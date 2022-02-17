package com.json.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.json.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{

}
