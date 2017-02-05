package com.saproject.onlineshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products_cart")
public class ProductCart {
	
	@Id
	@Column(name = "product_id")
	private String productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_quantity")
	private int productQuantity;
	@Column(name = "product_price")
	private int productPrice;
	
	public ProductCart() {}

	public ProductCart(String productId, String productName,
			int productQuantity, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
