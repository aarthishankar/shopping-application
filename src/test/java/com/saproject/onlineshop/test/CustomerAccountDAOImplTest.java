package com.saproject.onlineshop.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.saproject.onlineshop.dao.impl.CustomerAccountDAOImpl;
import com.saproject.onlineshop.entity.Customer;

@Controller
public class CustomerAccountDAOImplTest {

	int uId,intResult;
	boolean booleanResult;
	
	@Test
	public void test_saveNewUser() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		customer.setUserName("test");
		customer.setPassword("test");
		customer.setRole("customer");
		intResult=customerAccountDAOImpl.saveNewUser(customer);
		uId=customer.getUserId();
		customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(1,intResult);
	}
	
	@Test
	public void test_saveNewUser_returns0() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		customer.setUserName("test");
		customer.setPassword("test");
		customer.setRole("customer");
		customerAccountDAOImpl.saveNewUser(customer);
		uId=customer.getUserId();
		customer.setUserId(uId);
		intResult=customerAccountDAOImpl.saveNewUser(customer);
		customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(0,intResult);
	}
	
	@Test
	public void test_deleteAccount() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		customer.setUserName("test");
		customer.setPassword("test");
		customer.setRole("customer");
		customerAccountDAOImpl.saveNewUser(customer);
		uId=customer.getUserId();
		booleanResult=customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_isUserExists() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		customer.setUserName("test");
		customer.setPassword("test");
		customer.setRole("customer");
		customerAccountDAOImpl.saveNewUser(customer);
		booleanResult=customerAccountDAOImpl.isUserExists(customer);
		uId=customer.getUserId();
		customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_loginVerification() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		String userName="test";
		String password="test";
		customer.setUserName(userName);
		customer.setPassword(password);
		customer.setRole("customer");
		customerAccountDAOImpl.saveNewUser(customer);
		booleanResult=customerAccountDAOImpl.loginVerification(userName, password);
		uId=customer.getUserId();
		customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_loginVerification_returnsFalse() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		String userName="test";
		String password="test";
		customer.setUserName(userName);
		customer.setPassword(password);
		customer.setRole("customer");
		customerAccountDAOImpl.saveNewUser(customer);
		booleanResult=customerAccountDAOImpl.loginVerification("test1","test1");
		uId=customer.getUserId();
		customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(false,booleanResult);
	}
	
	@Test
	public void test_viewUsers() {
		CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
		Customer customer=new Customer();
		customer.setUserName("test");
		customer.setPassword("test");
		customer.setRole("customer");
		customerAccountDAOImpl.saveNewUser(customer);
		uId=customer.getUserId();
		List<Customer> userCart=null;
		userCart=customerAccountDAOImpl.viewUsers();
		if(userCart.isEmpty())
			booleanResult=false;
		else
			booleanResult=true;
		customerAccountDAOImpl.deleteAccount(uId);
		Assert.assertEquals(true,booleanResult);
	}
}
