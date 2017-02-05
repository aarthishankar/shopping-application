package com.saproject.onlineshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_description")
public class OrderDescription {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "username")
	private String userName;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_address")
	private String customerAddress;
	@Column(name = "customer_phone_number")
	private int customerPhoneNumber;
	@Column(name = "customer_email_id")
	private String customerEmailId;
	@Column(name = "product_ids")
	private String productIds;
	@Column(name = "product_quantities")
	private String productQuantities;
	@Column(name = "total_quantity")
	private int totalQuantity;
	@Column(name = "total_cost")
	private int totalCost;
	@Column(name = "order_date")
	private Date orderDate;
	
	public OrderDescription() {}

	public OrderDescription(int orderId, String userName, String customerName,
			String customerAddress, int customerPhoneNumber,
			String customerEmailId, String productIds,
			String productQuantities, int totalQuantity, int totalCost,
			Date orderDate) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmailId = customerEmailId;
		this.productIds = productIds;
		this.productQuantities = productQuantities;
		this.totalQuantity = totalQuantity;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public String getProductQuantities() {
		return productQuantities;
	}

	public void setProductQuantities(String productQuantities) {
		this.productQuantities = productQuantities;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	

}