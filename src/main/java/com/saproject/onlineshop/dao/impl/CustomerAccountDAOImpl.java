package com.saproject.onlineshop.dao.impl;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import com.saproject.onlineshop.dao.CustomerAccountDAO;
import com.saproject.onlineshop.entity.Customer;

public class CustomerAccountDAOImpl implements CustomerAccountDAO {

	private static SessionFactory sessionFactory;

	static
	{
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public int saveNewUser(Customer customer) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int result=0;
		try{
		tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		result=1;
		}
		catch (HibernateException e) {
		result=0;
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		
		}finally {
		session.close();
		}
		return result;
	}
	
	
	public boolean isUserExists(Customer customer){
		Session session = sessionFactory.openSession(); 
	    boolean existingUserTest=false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	         
	         Criteria cr=session.createCriteria(Customer.class);
	         cr.add(Restrictions.eq("userName",customer.getUserName()));
	         List ls=cr.list();
	         if(!ls.isEmpty())
	        	 existingUserTest=true;
	         else
	        	 existingUserTest=false;
	         tx.commit();
	     }catch(Exception ex){
	    	 System.out.println(ex.getMessage());
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	         
	     }
	     return existingUserTest;
	}
	
	public List<Customer> viewUsers() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Customer> customerlist=null;
		try{
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Customer.class);
		customerlist =cr.list();
		tx.commit();
		}
		catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return customerlist;
	}

	public boolean loginVerification(String username,String password)
	{
		Session session = sessionFactory.openSession(); 
	    boolean result=false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	         
	         Criteria cr=session.createCriteria(Customer.class);
	         cr.add(Restrictions.eq("userName",username));
	         
	         List customerresult = cr.list();
			 Iterator iterator=customerresult.iterator();
			 Customer customer;
	         if(!customerresult.isEmpty())
	         {
	        	customer=(Customer)iterator.next();
	 			String db_pass=customer.getPassword();
	 				if(password.equals(db_pass))
	 					result= true;
	         }
	         else
	        	 result= false;
	         tx.commit();
	     }catch(Exception ex){
	    	 result= false;
	    	 System.out.println(ex.getMessage());
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	     }
		return result;
	
	
	}	
	public boolean deleteAccount(int userId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.eq("userId",userId));
			List customerresult = cr.list();
			Iterator iterator=customerresult.iterator();
			Customer customerobject;
			if(iterator.hasNext())
			{
				customerobject=(Customer)iterator.next();
				session.delete(customerobject);
				System.out.println("Account deleted successfully.");
				result= true;
			}
			else
			result= false;
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return result;
		}
	
}
