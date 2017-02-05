package com.saproject.onlineshop.dao;

import java.util.List;
import com.saproject.onlineshop.entity.Customer;

public interface CustomerAccountDAO 
{	
	public int saveNewUser(Customer customer);
	public List<Customer> viewUsers();
	public boolean loginVerification(String username,String password);
	public boolean deleteAccount(int userId);
}
