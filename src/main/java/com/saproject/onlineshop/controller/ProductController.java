package com.saproject.onlineshop.controller;

import java.util.List;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

import com.saproject.onlineshop.dao.impl.ProductDAOImpl;
import com.saproject.onlineshop.entity.Product;

@Controller  
public class ProductController { 
	
	
	 @RequestMapping("/addProduct")  
	    public ModelAndView showAddProductForm(){  
		
	        return new ModelAndView("addProduct","command",new Product());  
	    } 
	
	 @RequestMapping(value="/saveProduct",method = RequestMethod.POST)  
	    public ModelAndView saveProduct(@ModelAttribute("product") Product product,HttpServletRequest request,HttpServletResponse res){  
		 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		 String filePath=request.getParameter("filePath");
		 String productId=product.getProductId();
		 String filePath2="";
	        for(int i=0;i<filePath.length();i++)
	        {
	        	char c=filePath.charAt(i);
	        	if(c=='\\')
	        		{
	        			filePath2=filePath2+"\\\\";
	        		}
	        	else
	        		filePath2=filePath2+c;
	        }
	        productDAOImpl.saveImage(productId,filePath2);
	        filePath2="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
	        product.setProductImage(filePath2);
	        boolean result=productDAOImpl.doesProductExists(product);
	        if(result==true)
	        {
	        	return new ModelAndView("addProductError", "msg","Sorry,Product with same Id already exists .Try adding different product with different Id. ");
	        }
	        else
	        {
	        	productDAOImpl.saveNewProduct(product);
	        	//System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity()); 
		        return new ModelAndView("redirect:/viewProducts");
		   
	        }
	        
	   }  
	 @RequestMapping("/deleteProduct")  
     public ModelAndView deletingProduct(HttpServletRequest request,HttpServletResponse response){  
	 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
  	String productId;
  
  	productId=request.getParameter("productId");
  	productDAOImpl.deleteProduct(productId);
      List<Product> list;
  	list=productDAOImpl.viewProducts(); 
	 	
      return new ModelAndView("viewProducts","productlist",list);  

}
	    @RequestMapping("/viewProducts")  
	    public ModelAndView viewProducts(){  
	    	
	    	ProductDAOImpl productDAOImpl=new ProductDAOImpl();
	    	
	    	List<Product> list;
	    	list=productDAOImpl.viewProducts();     
	        return new ModelAndView("viewProducts","productlist",list);  
	    }  
	 
	    @RequestMapping("/editProduct")  
	       public ModelAndView showeditForm(HttpServletRequest request,HttpServletResponse response){  
		
	    	return new ModelAndView("editProduct","command",new Product());  
	
	 }
	    
	    @RequestMapping(value="/editTheProduct",method = RequestMethod.POST)  
	    public ModelAndView editProduct(@ModelAttribute("product") Product product,HttpServletRequest request,HttpServletResponse res){  
		 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		 String filePath=request.getParameter("filePath");
		 String productId=product.getProductId();
		 String filePath2="";
	        for(int i=0;i<filePath.length();i++)
	        {
	        	char c=filePath.charAt(i);
	        	if(c=='\\')
	        		{
	        			filePath2=filePath2+"\\\\";
	        		}
	        	else
	        		filePath2=filePath2+c;
	        }
	        productDAOImpl.saveImage(productId,filePath2);
	        filePath2="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
	        product.setProductImage(filePath2);
	        productDAOImpl.updateProduct(product);
	        //System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity()); 
	        return new ModelAndView("redirect:/viewProducts");
	    }  
	    
	}  
