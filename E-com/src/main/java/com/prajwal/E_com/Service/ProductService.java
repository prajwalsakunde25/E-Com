package com.prajwal.E_com.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prajwal.E_com.Model.Product;
import com.prajwal.E_com.Repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	public ProductRepo repo;
	
	
	public List<Product> viewallproduct(){
		
		return repo.findAll();
	}

	public Product getproductbyid(int id) {
		
		return repo.findById(id).orElse(null);
	}


	public Product addproduct(Product product, MultipartFile imagefile) throws IOException {
		
		product.setImageName(imagefile.getOriginalFilename());
		product.setImageType(imagefile.getContentType());
		product.setImageDate(imagefile.getBytes());
		
		return repo.save(product);
	}


	public Product updateProduct(int id, Product product, MultipartFile imagefile) throws IOException {
		product.setImageName(imagefile.getOriginalFilename());
		product.setImageType(imagefile.getContentType());
		product.setImageDate(imagefile.getBytes());
		return repo.save(product);
	}


	public void deletedProduct(int id) {
		
		repo.deleteById(id);
	}


	public List<Product> searchProducts(String keyword) {
		
		return repo.searchProducts(keyword);
	}



	
}
