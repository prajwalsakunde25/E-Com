package com.prajwal.E_com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prajwal.E_com.Model.Product;

import jakarta.persistence.Query;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@org.springframework.data.jpa.repository.Query("SELECT p from Product p WHERE "
			+ "LOWER(p.name) like LOWER(CONCAT('%', :keyword,'%')) OR "
			+ "LOWER(p.description) like LOWER(CONCAT('%', :keyword,'%')) OR "
			+ "LOWER(p.brand) like LOWER(CONCAT('%', :keyword,'%')) OR "
			+ "LOWER(p.category) like LOWER(CONCAT('%', :keyword,'%'))"
			)
	
	List<Product> searchProducts(String keyword);

}
