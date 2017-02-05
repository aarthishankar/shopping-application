<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@page import="com.saproject.onlineshop.dao.impl.ProductDAOImpl"%>  
   <html>
   <body>
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
   </head>
   <body> 
    <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product Image</th><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th></th><th></th></tr>  
    <%
 	int pageCode;
 	int encryptedCode;
 	try
 	{
 		encryptedCode=Integer.parseInt(request.getParameter("code"));
 	}
 	catch(Exception e)
 	{
 		encryptedCode=6;
 	}
 	finally
 	{
 		
 	}%>
   
   <c:forEach var="product" items="${productlist}">   
   <tr>
   <c:set var="productID" value="${product.productId}"/>  
   <% 
       			
                String productID="";
                productID=productID+pageContext.getAttribute("productID");
           
                char c=' ';
               if(encryptedCode==1)
            	{
            	   c='T';
            	}
               else if(encryptedCode==2)
               {
            	   c='F';
               }
               else if(encryptedCode==3)
               {
            	   c='W';
               }
               else if(encryptedCode==4)
               {
            	   c='L';
               }
            	   
               else if(encryptedCode==5)
               {
            	   c='A';
               }
               else
            	   c='S';
               // out.println(c);
                if(c!='S')
                {
              	if(productID.charAt(0)==c)
                {
			%>       
					   <td><ul style="list-style: none;"><li><img src="Image Resources/Product Images/code_${product.productId}.jpg" /></li></ul></td> 
					   <td>${product.productId}</td>  
					   <td>${product.productName}</td>  
					   <td>${product.productPrice}</td>
					 <c:set var="pQuan" value="${product.productQuantity}"/>		
					   					<%
					   					String nameOfTheUser=session.getAttribute("nameOfTheUser").toString();
					   					String specificProductQuantity="";
					   					specificProductQuantity=specificProductQuantity+pageContext.getAttribute("pQuan");
					   					int productQuan=Integer.parseInt(specificProductQuantity);
					   					if(!(nameOfTheUser.equals("admin")))
					   					
					   						{
					   						if(productQuan>0)
					   						{
					   					
					   					%>    
					   <td><%out.println("Available");%></td>
					    <%
					       ProductDAOImpl productDAOImpl=new ProductDAOImpl();
					       boolean result=productDAOImpl.checkProductAddedInCart(productID);
					      if(result==false)
					      {%>
					   <td>
					   
					    <form:form method="post" action="addToCart">
					    	<input type="hidden" value="${product.productName}" name="productName"/>  
					    	<input type="hidden" value="${product.productPrice}" name="productPrice"/>  
					       <input type="hidden" value="${product.productId}" name="productId" id="productId"/>
					      <input type="submit" value="Add to cart"  />     
					   </form:form>
					   
					   
					   </td>  
					   <%}
					      else
					      { %>
					    	  <td><%  out.println("Already in Cart");}%></td>
					<% 
					   	   					}
					   	   						else
					   	   						{ %>
					   	   						 <td><% out.println("Out Of Stock");%></td>
					   	   						<% }
					   	
					}
					if(nameOfTheUser.equals("admin"))
					{%>
					<td>${product.productQuantity}</td>
					   <td>
					   
					   <form:form method="post" action="editProduct">
					       <input type="hidden" value="${product.productId}" name="productId"/>         
					      <input type="submit" value="Edit Product" />     
					   </form:form>
					   </td>
					   <td>
					   <form:form method="post" action="deleteProduct">
					       <input type="hidden" value="${product.productId}" name="productId"/>         
					      <input type="submit" value="Delete" />     
					   </form:form>
					   </td>
					   
   					<%} 
   
              }
              }
              else
              {
                 %>  					
   					<td><ul style="list-style: none;"><li><img src="Image Resources/Product Images/code_${product.productId}.jpg" /></li></ul></td> 
					   <td>${product.productId}</td>  
					   <td>${product.productName}</td>  
					   <td>${product.productPrice}</td>
					 <c:set var="pQuan" value="${product.productQuantity}"/>		
					   					<%
					   					String nameOfTheUser=session.getAttribute("nameOfTheUser").toString();
					   					String specificProductQuantity="";
					   					specificProductQuantity=specificProductQuantity+pageContext.getAttribute("pQuan");
					   					int productQuan=Integer.parseInt(specificProductQuantity);
					   					if(!(nameOfTheUser.equals("admin")))
					   					
					   						{
					   						if(productQuan>0)
					   						{
					   					
					   					%>    
					   <td><%out.println("Available");%></td>
					    <% ProductDAOImpl productDAOImpl=new ProductDAOImpl();
					       boolean result=productDAOImpl.checkProductAddedInCart(productID);
					      if(result==false)
					      {%>
					   
					   <td>
					   
					    <form:form method="post" action="addToCart">
					    	<input type="hidden" value="${product.productName}" name="productName"/>  
					    	<input type="hidden" value="${product.productPrice}" name="productPrice"/>  
					       <input type="hidden" value="${product.productId}" name="productId"/>         
					      <input type="submit" value="Add to cart"  />        
					   
					   </form:form>
					   
					   
					   </td>  
					   <%
					      }
					      else
					      { %>
						    <td><%  out.println("Already in Cart");}%></td>
					   	   				<% 	}
					   	   						else
					   	   						{ %>
					   	   						 <td><% out.println("Out Of Stock");%></td>
					   	   						<% }
					   	
					}
					if(nameOfTheUser.equals("admin"))
					{%>
					<td>${product.productQuantity}</td>
					   <td>
					   
					   <form:form method="post" action="editProduct">
					       <input type="hidden" value="${product.productId}" name="productId"/>         
					      <input type="submit" value="Edit Product" />     
					   </form:form>
					   </td>
   						<td>
					   <form:form method="post" action="deleteProduct">
					       <input type="hidden" value="${product.productId}" name="productId"/>         
					      <input type="submit" value="Delete" />     
					   </form:form>
					   </td>
   					
   					
   					
   					
   					
   					
   					
   					
   				<% 
              }
   				}%>	
   </tr>  
   </c:forEach> 
   
   
   
   </table>  
   <br/>
   <br/>
   <%
   String nameOfTheUser=session.getAttribute("nameOfTheUser").toString();
		String specificProductQuantity="";
   if(!(nameOfTheUser.equals("admin")))
	{%>
    <center><b><a href="viewCart">View MyCart</a></b></center>
    <%} %>
   </body>  
   </html> 