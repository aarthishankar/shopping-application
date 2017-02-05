package com.saproject.onlineshop.dao.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.saproject.onlineshop.dao.ProductDAO;
import com.saproject.onlineshop.entity.Product;
import com.saproject.onlineshop.entity.ProductCart;

public class ProductDAOImpl implements ProductDAO {

	private static SessionFactory sessionFactory;
	static
	{
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(ProductCart.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public int saveNewProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int result=0;
		try{
		tx = session.beginTransaction();
		session.save(product);
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

	public boolean doesProductExists(Product product){
		Session session = sessionFactory.openSession(); 
	    boolean existingProductTest=false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	         
	         Criteria cr=session.createCriteria(Product.class);
	         cr.add(Restrictions.eq("productId",product.getProductId()));
	         List ls=cr.list();
	         if(!ls.isEmpty())
	        	 existingProductTest=true;
	         else
	        	 existingProductTest=false;
	         tx.commit();
	     }catch(Exception ex){
	    	 System.out.println(ex.getMessage());
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	         
	     }
	     return existingProductTest;
	}
	
	public int saveImage(String productId,String path)
	  {
	    int width = 960;    
	    int height = 640;   
	    BufferedImage image = null;
	    File f = null;

	    //read image
	    try{
	      f = new File(path); //image file path
	      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	      image = ImageIO.read(f);
	     /* System.out.println("Reading complete.");
	      image =ImageIO.read(getClass().getResource(path));
	      System.out.println("Reading dONE.");
	     */ 
	      //System.out.println("Reading complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }

	    //write image
	    try{
	      f = new File("C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+productId+".jpg");  //output file path
	      ImageIO.write(image, "jpg", f);
	      //System.out.println("Writing complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	  
	    return 0;
	  }
	
	public boolean deleteProduct(String productId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productId",productId));
			List productresult = cr.list();
			Iterator iterator=productresult.iterator();
			Product productobject;
			if(iterator.hasNext())
			{
				productobject=(Product)iterator.next();
				session.delete(productobject);
				System.out.println("Product deleted successfully.");
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
	
	public int updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int result=0;
		try{
		tx = session.beginTransaction();
		session.update(product);
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
	
	public List<Product> viewProducts() {
			
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			List<Product> productlist=null;
			try{
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			productlist =cr.list();
			tx.commit();
			}
			catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
			session.close();
			}
			return productlist;
		}
	
	public int getProductPriceForId(String productId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		int productPrice=0;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productId",productId));
			List productresult = cr.list();
			Iterator iterator=productresult.iterator();
			Product productobject;
			
				productobject=(Product)iterator.next();
				productPrice=productobject.getProductPrice();
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return productPrice;
		}
	
	public int getProductQuantityForId(String productId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		int productQuantity=0;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productId",productId));
			List productresult = cr.list();
			Iterator iterator=productresult.iterator();
			Product productobject;
			
				productobject=(Product)iterator.next();
				productQuantity=productobject.getProductQuantity();
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return productQuantity;
		}
	
	public boolean checkProductAddedInCart(String productId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		int productQuantity=0;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(ProductCart.class);
			cr.add(Restrictions.eq("productId",productId));
			List productcartresult = cr.list();
			if(productcartresult.isEmpty())
				result=false;
			else
				result=true;
			tx.commit();
		
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return result;
		}
	
	
	public int saveProductToCart(ProductCart productCart) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int result=0;
		try{
		tx = session.beginTransaction();
		session.save(productCart);
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
	
	public int updateProductToCart(ProductCart productCart) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int result=0;
		try{
		tx = session.beginTransaction();
		session.update(productCart);
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
	
	public boolean deleteProductFromCart(String productId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		try{
		tx = session.beginTransaction();
			Criteria cr = session.createCriteria(ProductCart.class);
			cr.add(Restrictions.eq("productId",productId));
			List productresult = cr.list();
			Iterator iterator=productresult.iterator();
			ProductCart productcartobject;
			if(iterator.hasNext())
			{
				productcartobject=(ProductCart)iterator.next();
				session.delete(productcartobject);
				System.out.println("Product deleted from cart successfully.");
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
	
	
	
	
	public List<ProductCart> viewProductsCart() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ProductCart> productCartlist=null;
		try{
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(ProductCart.class);
		productCartlist =cr.list();
		tx.commit();
		}
		catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return productCartlist;
	}
	
		public boolean checkIsProductsCartEmpty() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result=false;
		List<ProductCart> productCartlist=null;
		try{
		tx = session.beginTransaction();
		Long nRows= (Long) session.createCriteria(ProductCart.class).setProjection(Projections.rowCount()).uniqueResult();
		if(nRows!=0)
			result=false;
		else
			result=true;
		tx.commit();
		}
		catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return result;
	}
	
	
	
}
