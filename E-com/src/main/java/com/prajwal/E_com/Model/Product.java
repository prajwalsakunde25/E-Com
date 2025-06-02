package com.prajwal.E_com.Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;



@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String category;
	private String brand;
	private BigDecimal price;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date releaseDate;
	private boolean productAvailable;
	private int stockQuantity;
	
	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}

	public int getStockquantity() {
		return stockQuantity;
	}

	public void setStockquantity(int stockquantity) {
		this.stockQuantity = stockquantity;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageDate() {
		return imageDate;
	}

	public void setImageDate(byte[] imageDate) {
		this.imageDate = imageDate;
	}

	public Product(int id, String name, String description, String category, String brand, BigDecimal price,
			Date releaseDate, boolean productAvailable, int stockquantity, String imageName, String imageType,
			byte[] imageDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.releaseDate = releaseDate;
		this.productAvailable = productAvailable;
		this.stockQuantity = stockquantity;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageDate = imageDate;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", brand=" + brand + ", price=" + price + ", releaseDate=" + releaseDate + ", productAvailable="
				+ productAvailable + ", stockquantity=" + stockQuantity + ", imageName=" + imageName + ", imageType="
				+ imageType + ", imageDate=" + Arrays.toString(imageDate) + "]";
	}

	
	
	
	
	
}
