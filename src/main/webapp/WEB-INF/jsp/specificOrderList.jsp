<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <jsp:useBean id="now" class="java.util.Date" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@ page import="java.io.*"%>
   <%@page import="com.saproject.onlineshop.dao.impl.ProductDAOImpl"%>
   <%@page import="com.saproject.onlineshop.entity.Product"%>   
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include> 
<style>
   table { 
  width: 100%; 
  border-collapse: collapse; 
}
/* Zebra striping */
tr:nth-of-type(odd) { 
  background: #eee; 
}
th { 
  background: #333; 
  color: white; 
  font-weight: bold; 
}
td, th { 
  padding: 6px; 
  border: 1px solid #ccc; 
  text-align: left; 
}
   </style>
 	<table border="2" width="100%" cellpadding="2">  
	<tr><th>Order Id</th><th>User name</th><th>Customer Name</th><th>Customer Address</th><th>Customer Phone Number</th><th>Customer Email Id</th><th>Total Quantity</th><th>Total Cost</th><th>Order Date</th><th></th></tr>  
	   <c:forEach var="specificOrderDesc" items="${SpecificOrderDescriptionlist}">   
	   <tr>  
	  
	 <tr>  
	   <td>${specificOrderDesc.orderId}</td> 
	   <td>${specificOrderDesc.userName}</td>  
	   <td>${specificOrderDesc.customerName}</td>  
	   <td>${specificOrderDesc.customerAddress}</td>  
	   <td>${specificOrderDesc.customerPhoneNumber}</td>
	   <td>${specificOrderDesc.customerEmailId}</td> 
	   <td>${specificOrderDesc.totalQuantity}</td>  
	   <td>${specificOrderDesc.totalCost}</td>
	   <td>${specificOrderDesc.orderDate}</td>
	    <fmt:formatDate var="datef" pattern="yyyy-MM-dd HH:mm:ss.0" value="${now}" />
            <fmt:formatDate var="datef1" pattern="yyyy-MM-dd HH:mm:ss.0" value="${specificOrderDesc.orderDate}" />
            <c:set var="date1" value="${datef1}"/>	
			<c:set var="date2" value="${datef}"/>	
			
			<%
					String orderStatus="";
					String date1 = "";
			  		date1 = date1+pageContext.getAttribute("date1");
			  		String date2 = "";
			  		date2 = date2+pageContext.getAttribute("date2");
			  		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
			  		Date d1 = null;
					Date d2 = null;

					try {
						d1 = df.parse(date1);
						d2 = df.parse(date2);

						//in milliseconds
						long diff = d2.getTime() - d1.getTime();
						diff=diff/1000;
						//out.println(diff);
						if(diff<120)
							orderStatus="Processed";
						else if(diff>=120&&diff<180)
							orderStatus="Shipped";
						else
							orderStatus="Delivered";
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(!(orderStatus.equals("Delivered")))
					{
					%>
	   
	   <td>
	    <form:form method="post" action="cancelOrder">
	    	<input type="hidden" value="${specificOrderDesc.orderId}" name="orderId"/> 
	    	<input type="hidden" value="${specificOrderDesc.productIds}" name="productIds"/> 
	    	<input type="hidden" value="${specificOrderDesc.productQuantities}" name="productQuantities"/>  
	      <input type="submit" value="Cancel Order" />     
	   </form:form>
	   
   
   </td>
   
   <%} %>  
   </tr> 
   <tr>
   <td colspan="9">
   
   <h3>Order Status</h3>
         <ul style="list-style: none;">
			<li>Order <%out.println(orderStatus);%>  </li>
			</ul>
   
   
   </td>
   
   </tr>
   <tr>
   <td>
    		<c:set var="pIDs" value="${specificOrderDesc.productIds}"/>	
			<c:set var="PQuantities" value="${specificOrderDesc.productQuantities}"/>	
   					<%
   					String productIds="";
   					productIds=productIds+pageContext.getAttribute("pIDs");
   					String productQuantities="";
   					productQuantities=productQuantities+pageContext.getAttribute("PQuantities");
   					ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		         	List<Product> list;
		 	    	list=productDAOImpl.viewProducts(); 
   					String productId[]=productIds.split("_");
   					String productQuantity[]=productQuantities.split("_");
   					int pPrice,pQuan;
   					%>
   
   
				   <table border="2" width="100%" cellpadding="2">  
				   <tr><th>Product Image</th><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Total Price Per Product</th><th></th></tr>  
				   <c:forEach var="product" items="<%=list%>">   
				   <tr>
				  <c:set var="pID" value="${product.productId}"/>
				  <c:set var="pPrice" value="${product.productPrice}"/>		
   					<%
   					String specificProductId="";
   					specificProductId=specificProductId+pageContext.getAttribute("pID");
   					String productPrice="";
   				    productPrice=productPrice+pageContext.getAttribute("pPrice");
				    for(int i=1;i<productId.length;i++)
				    {
				    	if(specificProductId.equals(productId[i]))
				    		{
				   %> 
				   <td><ul style="list-style: none;"><li><img src="Image Resources/Product Images/code_${product.productId}.jpg" /></li></ul></td> 
				   <td>${product.productId}</td>  
				   <td>${product.productName}</td>  
				   <td>${product.productPrice}</td>  
				   <td><%=productQuantity[i]%></td>
				   <td><%
				   	     pQuan=Integer.parseInt(productQuantity[i]);
				   	     pPrice=Integer.parseInt(productPrice);
				   	     out.println("Rs. "+(pPrice*pQuan));
				   			%></td> 
				   <% 		break;
				    		}
				    } %>
				   </tr>  
				   </c:forEach>  
				   </table>
   
   
   </td>
   </tr> 
   </c:forEach> 
   
   </table>  