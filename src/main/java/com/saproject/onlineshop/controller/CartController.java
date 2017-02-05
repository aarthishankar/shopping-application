package com.saproject.onlineshop.controller;

import java.util.List;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  

import com.saproject.onlineshop.dao.impl.ProductDAOImpl;
import com.saproject.onlineshop.entity.Product;
import com.saproject.onlineshop.entity.ProductCart;

@Controller  
public class CartController { 
	
	private int defaultProductPrice;
	
	 @RequestMapping("/addToCart")  
	        public ModelAndView addingProductToCart(HttpServletRequest request,HttpServletResponse response){  
		    ProductDAOImpl productDAOImpl=new ProductDAOImpl();
	    	String productId,productName;
	    	int productPrice,productQuantity;
	    	productId=request.getParameter("productId");
	    	productName=request.getParameter("productName");
	    	productPrice=Integer.parseInt(request.getParameter("productPrice"));
	    	productQuantity=1;
	    	defaultProductPrice=productPrice;
	    	ProductCart productCart=new ProductCart();
	    	productCart.setProductId(productId);
	    	productCart.setProductName(productName);
	    	productCart.setProductPrice(productPrice);
	    	productCart.setProductQuantity(productQuantity);
	    	productDAOImpl.saveProductToCart(productCart);
	        List<ProductCart> list;
	    	list=productDAOImpl.viewProductsCart(); 
	        return new ModelAndView("cartList","productCartlist",list);  
	
	 }
	 
	 @RequestMapping("/updateCart")  
     public ModelAndView showUpdatedCart(HttpServletRequest request,HttpServletResponse response){  
	 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
  	String productId,productName;
  	int productPrice,productQuantity;
  	productId=request.getParameter("productId");
  	productName=request.getParameter("productName");
  	productPrice=Integer.parseInt(request.getParameter("productPrice"));
  	productQuantity=Integer.parseInt(request.getParameter("productQuantity"));
  	
  	ProductCart productCart=new ProductCart();
  	productCart.setProductId(productId);
  	productCart.setProductName(productName);
  	productPrice=productDAOImpl.getProductPriceForId(productId);
  	productCart.setProductPrice(productPrice);
  	productCart.setProductQuantity(productQuantity);
  	productDAOImpl.updateProductToCart(productCart);
      List<ProductCart> list;
  	list=productDAOImpl.viewProductsCart(); 
	 	
      return new ModelAndView("cartList","productCartlist",list);  

}
	 @RequestMapping("/deleteFromCart")  
     public ModelAndView showUpdatedCartAfterDelete(HttpServletRequest request,HttpServletResponse response){  
	 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
  	String productId;
  
  	productId=request.getParameter("productId");
  	productDAOImpl.deleteProductFromCart(productId);
      List<ProductCart> list;
  	list=productDAOImpl.viewProductsCart(); 
	 	
      return new ModelAndView("cartList","productCartlist",list);  

}


	 @RequestMapping("/viewCart")  
	    public ModelAndView viewProductsInCart(){  
		 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		 List<ProductCart> list;
	  	list=productDAOImpl.viewProductsCart(); 
		 	
	      return new ModelAndView("cartList","productCartlist",list);  
}
	 
	 
	 @RequestMapping("/continueToProductList")  
     public ModelAndView moveToProductList(){  
		 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
	    	
	    	List<Product> list;
	    	list=productDAOImpl.viewProducts();     
	        return new ModelAndView("viewProducts","productlist",list);  

}
	 
}
	 

	
