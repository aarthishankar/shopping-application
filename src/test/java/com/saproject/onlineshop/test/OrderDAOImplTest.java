package com.saproject.onlineshop.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.saproject.onlineshop.dao.impl.OrderDAOImpl;
import com.saproject.onlineshop.entity.OrderDescription;

public class OrderDAOImplTest {
	
	int oId,intResult;
	boolean booleanResult;
	
	@Test
	public void test_saveNewOrder()
	{
		OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
		OrderDescription orderDescription=new OrderDescription();
		String productIds="_L001";
		String productQuantities="_2";
		orderDescription.setUserName("test");
		orderDescription.setCustomerName("test");
		orderDescription.setCustomerEmailId("test@gmail.com");
		orderDescription.setCustomerAddress("lucknow");
		orderDescription.setCustomerPhoneNumber(1234567890);
		orderDescription.setProductIds(productIds);
		orderDescription.setProductQuantities(productQuantities);
		orderDescription.setTotalQuantity(2);
		orderDescription.setTotalCost(20000);
		intResult=orderDAOImpl.saveNewOrder(orderDescription);
		oId=orderDescription.getOrderId();
		orderDAOImpl.cancelOrderAndUpdateQuantities(oId,productIds,productQuantities);
		Assert.assertEquals(1,intResult);
	}
	
	@Test
	public void test_cancelOrderAndUpdateQuantities()
	{
		OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
		OrderDescription orderDescription=new OrderDescription();
		String productIds="_L001";
		String productQuantities="_2";
		orderDescription.setUserName("test");
		orderDescription.setCustomerName("test");
		orderDescription.setCustomerEmailId("test@gmail.com");
		orderDescription.setCustomerAddress("lucknow");
		orderDescription.setCustomerPhoneNumber(1234567890);
		orderDescription.setProductIds(productIds);
		orderDescription.setProductQuantities(productQuantities);
		orderDescription.setTotalQuantity(2);
		orderDescription.setTotalCost(20000);
		orderDAOImpl.saveNewOrder(orderDescription);
		oId=orderDescription.getOrderId();
		booleanResult=orderDAOImpl.cancelOrderAndUpdateQuantities(oId,productIds,productQuantities);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_orderAndUpdateQuantities()
	{
		OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
		String productIds="_L001";
		String productQuantities="_2";
		booleanResult=orderDAOImpl.orderAndUpdateQuantities(productIds, productQuantities);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_viewOrders() {
		OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
		OrderDescription orderDescription=new OrderDescription();
		String productIds="_L001";
		String productQuantities="_2";
		orderDescription.setUserName("test");
		orderDescription.setCustomerName("test");
		orderDescription.setCustomerEmailId("test@gmail.com");
		orderDescription.setCustomerAddress("lucknow");
		orderDescription.setCustomerPhoneNumber(1234567890);
		orderDescription.setProductIds(productIds);
		orderDescription.setProductQuantities(productQuantities);
		orderDescription.setTotalQuantity(2);
		orderDescription.setTotalCost(20000);
		orderDAOImpl.saveNewOrder(orderDescription);
		oId=orderDescription.getOrderId();
		List<OrderDescription> orderCart=null;
		orderCart=orderDAOImpl.viewOrders();
		if(orderCart.isEmpty())
			booleanResult=false;
		else
			booleanResult=true;
		orderDAOImpl.cancelOrderAndUpdateQuantities(oId,productIds,productQuantities);
		Assert.assertEquals(true,booleanResult);
	}
}
