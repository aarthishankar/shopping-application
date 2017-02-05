package com.saproject.onlineshop.controller;

import java.util.List;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

import com.saproject.onlineshop.dao.impl.CustomerAccountDAOImpl;
import com.saproject.onlineshop.dao.impl.OrderDAOImpl;
import com.saproject.onlineshop.entity.Customer;

@Controller  
public class AccountController {  
	
		@RequestMapping("/login")  
	    public ModelAndView login(HttpServletRequest request,HttpServletResponse res) {  
	        String username=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
	        boolean result=customerAccountDAOImpl.loginVerification(username, password);
	        if(result==true){
	        HttpSession session=request.getSession();
	        session.setAttribute("nameOfTheUser",username);
	        String message = "HELLO "+username;  
	        return new ModelAndView("hellopage", "msg", message);  
	        }  
	        else{  
	            return new ModelAndView("errorpage", "msg","Sorry,Invalid username or password ");  
	        }  
	    }  
	  
	    @RequestMapping("/signUp")  
	    public ModelAndView showSignUpform(){  
	        return new ModelAndView("signUp","command",new Customer());  
	    }  
	    @RequestMapping(value="/save",method = RequestMethod.POST)  
	    public ModelAndView saveAccount(@ModelAttribute("cust") Customer customer){  
	        
	      //  System.out.println(customer.getUserName()+" "+customer.getPassword()+" "+customer.getRole()); 
	        CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
	        customer.setRole("customer");
	        boolean result=customerAccountDAOImpl.isUserExists(customer);
	        if(result==true)
	        {
	        	return new ModelAndView("signUpError", "msg","Sorry,User already exists .Try different User Name ");
	        }
	        else
	        {
	        customerAccountDAOImpl.saveNewUser(customer);
	        return new ModelAndView("redirect:/loginpage");
	        }
	    }  
	      
	    @RequestMapping("/viewCustomers")  
	    public ModelAndView viewCustomers(){  
	    	
	    	CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
	    	List<Customer> list;
	    	list=customerAccountDAOImpl.viewUsers();      
	        return new ModelAndView("viewCustomers","list",list);  
	    }  
	    
	    @RequestMapping("/logout")  
	    public ModelAndView logout(){  
	    	OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
	    	orderDAOImpl.deleteAllProductFromCart();
	        return new ModelAndView("logout");  
	    }  
	    
	    @RequestMapping("/loginpage")  
	    public ModelAndView loginpage(){  
	        return new ModelAndView("loginpage");  
	    }  
	    
	    @RequestMapping("/deleteAccount")  
	     public ModelAndView deleteAccount(HttpServletRequest request,HttpServletResponse response){  
	    	CustomerAccountDAOImpl customerAccountDAOImpl=new CustomerAccountDAOImpl();
	  	String userId;
	  	userId=request.getParameter("userId");
	  	int uID=Integer.parseInt(userId);
	  	customerAccountDAOImpl.deleteAccount(uID);
    	List<Customer> list;
    	list=customerAccountDAOImpl.viewUsers();      
        return new ModelAndView("viewCustomers","list",list);   

	}
	    
	}  
