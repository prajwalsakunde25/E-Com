package com.prajwal.E_com.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prajwal.E_com.Model.Product;
import com.prajwal.E_com.Service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class ProductController {

	@Autowired
	public ProductService service;
	
	@GetMapping("/test")
	public String testLombok() {
		
	    Product user = new Product();
	    user.setId(1);
	    user.setName("Test User");
	    System.out.println("Name: " + user.getName()); // Check your console/logs
	    return "Test passed!";
	}

	
	@GetMapping("/products")
	public List<Product> viewallproduct(){
		
		return service.viewallproduct();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getprod(@PathVariable int id) {
		
		
		Product pro=service.getproductbyid(id);
		
		if(pro!=null) {
			return new ResponseEntity<>(pro,HttpStatus.OK); 
		}
		
		else {
			return new ResponseEntity<>(pro,HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/product")
	public ResponseEntity<?> product(@RequestPart("product") Product product,
									@RequestPart("imageFile") MultipartFile imagefile){
		
		Product product1;
		try {
			product1 = service.addproduct(product,imagefile);
			return new ResponseEntity<>(product1,HttpStatus.OK);
		} catch (Exception e) {
			
			return new  ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("product/{productid}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productid){
		
		Product product=service.getproductbyid(productid);
		
		byte[] imagefile=product.getImageDate();
		
		return ResponseEntity.ok().body(imagefile);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart("product") Product product,
			@RequestPart("imageFile") MultipartFile imagefile){
		
		Product product1;
		try {
			product1 = service.updateProduct(id,product,imagefile);
		} catch (IOException e) {
			return new ResponseEntity<String>("Failed to update",HttpStatus.BAD_REQUEST);
		}
		
		if(product1!=null) {
			return new ResponseEntity<String>("Updated",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Failed to update",HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		
		Product product1=service.getproductbyid(id);
		
		if(product1!=null) {
			service.deletedProduct(id);
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Failed to delete",HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
		List<Product> products= service.searchProducts(keyword);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
}
