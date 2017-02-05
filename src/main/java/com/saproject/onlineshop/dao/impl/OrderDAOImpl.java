package com.saproject.onlineshop.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.saproject.onlineshop.dao.OrderDAO;
import com.saproject.onlineshop.entity.OrderDescription;
import com.saproject.onlineshop.entity.Product;

public class OrderDAOImpl implements OrderDAO {
	
	private static SessionFactory sessionFactory;
	static
	{
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(OrderDescription.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public int saveNewOrder(OrderDescription orderDescription) {
			
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			int result=0;
			try{
			tx = session.beginTransaction();
			orderDescription.setOrderDate(new Date());
			session.save(orderDescription);
			OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
			String productIds=orderDescription.getProductIds();
			String productQuantities=orderDescription.getProductQuantities();
			orderDAOImpl.orderAndUpdateQuantities(productIds, productQuantities);
	        orderDAOImpl.deleteAllProductFromCart();
			result=1;
			tx.commit();
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
	
	
	public boolean deleteAllProductFromCart() {
	
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		try{
		tx = session.beginTransaction();
			session.createQuery("delete from ProductCart").executeUpdate();	
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return result;
		}

	
	public boolean cancelOrderAndUpdateQuantities(int orderId,String productIds,String productQuantities) {
	
		
		String productId[]=productIds.split("_");	
		String productQuantity[]=productQuantities.split("_");
		OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
		int pQuantity;
		for(int i=1;i<productId.length;i++)
			{
			pQuantity=Integer.parseInt(productQuantity[i]);
			orderDAOImpl.updateProductQuantitiesOnCancel(productId[i],pQuantity);
			}
			Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(OrderDescription.class);
			cr.add(Restrictions.eq("orderId",orderId));
			List orderDescriptionresult  = cr.list();
			Iterator iterator=orderDescriptionresult.iterator();
			OrderDescription orderDescriptionobject;
			if(iterator.hasNext())
			{
				orderDescriptionobject=(OrderDescription)iterator.next();
				session.delete(orderDescriptionobject);
				System.out.println("Order deleted successfully.");
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
	
	public boolean updateProductQuantitiesOnCancel(String productId,int productQuantity) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int productQuan=0;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productId",productId));
			List productresult = cr.list();
			Iterator iterator=productresult.iterator();
			Product productobject;
			
				productobject=(Product)iterator.next();
				productQuan=productobject.getProductQuantity();
				productQuantity=productQuantity+productQuan;
				productobject.setProductQuantity(productQuantity);
				session.update(productobject);
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return true;
		}
		

public boolean orderAndUpdateQuantities(String productIds,String productQuantities) {
	
		
		String productId[]=productIds.split("_");	
		String productQuantity[]=productQuantities.split("_");
		OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
		int pQuantity;
		try{
		for(int i=1;i<productId.length;i++)
			{
			pQuantity=Integer.parseInt(productQuantity[i]);
			orderDAOImpl.updateProductQuantitiesOnOrder(productId[i],pQuantity);
			}
		
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		}
	
	public boolean updateProductQuantitiesOnOrder(String productId,int productQuantity) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int productQuan=0;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productId",productId));
			List productresult = cr.list();
			Iterator iterator=productresult.iterator();
			Product productobject;
			
				productobject=(Product)iterator.next();
				productQuan=productobject.getProductQuantity();
				productQuan=productQuan-productQuantity;
				productobject.setProductQuantity(productQuan);
				session.update(productobject);
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return true;
		}
		
	
	
	
	public List<OrderDescription> viewOrders() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<OrderDescription> orderDescriptionlist=null;
		try{
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(OrderDescription.class);
		orderDescriptionlist =cr.list();
		tx.commit();
		}
		catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return orderDescriptionlist;
	}

}
