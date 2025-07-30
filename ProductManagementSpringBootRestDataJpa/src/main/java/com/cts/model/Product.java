package com.cts.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid", length = 3, nullable = false)
	@GeneratedValue
	@NotNull
	private int productId;
	@Min(value=1000,message="Min Price Required is 1000 ")
	private int productPrice;
	@Size(min=6,message="Min Length of Product Name not satisfied")
	private String productName;
	@Size(min=6,message="Min Length of Product Name not satisfied")
	private String productCategory;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Product() {

	}

	public Product( int productPrice, String productName, String productCategory) {
		super();
	
		this.productPrice = productPrice;
		this.productName = productName;
		this.productCategory = productCategory;
	}

}
