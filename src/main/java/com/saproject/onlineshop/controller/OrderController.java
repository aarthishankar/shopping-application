package com.saproject.onlineshop.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.saproject.onlineshop.dao.impl.OrderDAOImpl;
import com.saproject.onlineshop.entity.OrderDescription;


@Controller
public class OrderController {
	
	@RequestMapping("/placingOrder")  
    public ModelAndView showPlacingOrderForm(){
		 
        return new ModelAndView("placingOrder","command",new OrderDescription());  
    }  
    @RequestMapping(value="/saveOrder",method = RequestMethod.POST)  
    public ModelAndView saveNewOrder(@ModelAttribute("orderDesc") OrderDescription orderDescription,HttpServletRequest request){  
        
    	HttpSession session=request.getSession();
    	String uName=session.getAttribute("nameOfTheUser").toString();
    	orderDescription.setUserName(uName);
    	OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
        orderDAOImpl.saveNewOrder(orderDescription);
        return new ModelAndView("redirect:/viewOrders");
    } 
    
    @RequestMapping("/viewOrders")  
    public ModelAndView viewOrders(){  
    	
    	OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
    	List<OrderDescription> list;
    	list=orderDAOImpl.viewOrders();     
        return new ModelAndView("viewOrders","orderDescriptionlist",list);  
    }  
    
    @RequestMapping("/viewSpecificOrder")  
    public ModelAndView viewSpecificOrder(HttpServletRequest request,HttpServletResponse response) throws ParseException{ 
	 int orderId,customerPhoneNumber,totalQuantity,totalCost;
	 String userName,customerName,customerAddress,customerEmailId,productIds,productQuantities;
	 Date orderDate;
 	userName=request.getParameter("userName");
 	customerName=request.getParameter("customerName");
 	customerPhoneNumber=Integer.parseInt(request.getParameter("customerPhoneNumber"));
 	customerAddress=request.getParameter("customerAddress");
 	productIds=request.getParameter("productIds");
 	productQuantities=request.getParameter("productQuantities");
 	customerEmailId=request.getParameter("customerEmailId");
 	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0", Locale.ENGLISH);
 	orderDate = format.parse(request.getParameter("orderDate"));
 	 orderId=Integer.parseInt(request.getParameter("orderId"));
 	totalQuantity=Integer.parseInt(request.getParameter("totalQuantity"));
 	totalCost=Integer.parseInt(request.getParameter("totalCost"));
 	OrderDescription orderDescription=new OrderDescription();
 	orderDescription.setOrderId(orderId);
 	orderDescription.setUserName(userName);
 	orderDescription.setCustomerName(customerName);
 	orderDescription.setCustomerAddress(customerAddress);
 	orderDescription.setCustomerEmailId(customerEmailId);
 	orderDescription.setCustomerPhoneNumber(customerPhoneNumber);
 	orderDescription.setOrderDate(orderDate);
 	orderDescription.setTotalCost(totalCost);
 	orderDescription.setTotalQuantity(totalQuantity);
 	orderDescription.setProductIds(productIds);
 	orderDescription.setProductQuantities(productQuantities);
 	ArrayList<OrderDescription> list=new ArrayList<OrderDescription>();
 	list.add(orderDescription);
     return new ModelAndView("specificOrderList","SpecificOrderDescriptionlist",list);  

}
    
    @RequestMapping("/cancelOrder")  
    public ModelAndView cancelOrder(HttpServletRequest request,HttpServletResponse response) throws ParseException{ 
	 int orderId;
	 String productIds,productQuantities;
 	productIds=request.getParameter("productIds");
 	productQuantities=request.getParameter("productQuantities");
 	orderId=Integer.parseInt(request.getParameter("orderId"));
 	OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
 	orderDAOImpl.cancelOrderAndUpdateQuantities(orderId,productIds,productQuantities);
 	 return new ModelAndView("redirect:/viewOrders");  

}
    
}
