<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
<tr><th>Order Id</th><th>User name</th><th>Customer Name</th><th>Customer Address</th><th>Customer Phone Number</th><th>Customer Email Id</th><th>Total Quantity</th><th>Total Cost</th><th>Order Date</th><th></th></tr>  
   <c:forEach var="orderDesc" items="${orderDescriptionlist}">   
   <tr>
    				<c:set var="uName" value="${orderDesc.userName}"/>	
   					<%
   					String userName="";
   					userName=userName+pageContext.getAttribute("uName");
					String nameOfTheUser=session.getAttribute("nameOfTheUser").toString();
					if(nameOfTheUser.equals(userName))
					{%>  
   <td>${orderDesc.orderId}</td> 
   <td>${orderDesc.userName}</td>  
   <td>${orderDesc.customerName}</td>  
   <td>${orderDesc.customerAddress}</td>  
   <td>${orderDesc.customerPhoneNumber}</td>
   <td>${orderDesc.customerEmailId}</td> 
   <td>${orderDesc.totalQuantity}</td>  
   <td>${orderDesc.totalCost}</td>
   <td>${orderDesc.orderDate}</td>
   
   <td>
    <form:form method="post" action="viewSpecificOrder">
    	<input type="hidden" value="${orderDesc.orderId}" name="orderId"/>  
    	<input type="hidden" value="${orderDesc.userName}" name="userName"/>  
       <input type="hidden" value="${orderDesc.customerName}" name="customerName"/>     
       <input type="hidden" value="${orderDesc.customerAddress}" name="customerAddress"/>  
    	<input type="hidden" value="${orderDesc.customerPhoneNumber}" name="customerPhoneNumber"/>  
       <input type="hidden" value="${orderDesc.customerEmailId}" name="customerEmailId"/>     
       <input type="hidden" value="${orderDesc.totalQuantity}" name="totalQuantity"/>  
    	<input type="hidden" value="${orderDesc.totalCost}" name="totalCost"/>  
       <input type="hidden" value="${orderDesc.orderDate}" name="orderDate"/>  
       <input type="hidden" value="${orderDesc.productIds}" name="productIds"/>  
       <input type="hidden" value="${orderDesc.productQuantities}" name="productQuantities"/>  
      <input type="submit" value="View" />     
   </form:form>
   
   
   </td>  
   <%} 
					else if(nameOfTheUser.equals("admin"))
					{
						%>
						
						 <td>${orderDesc.orderId}</td> 
				   <td>${orderDesc.userName}</td>  
				   <td>${orderDesc.customerName}</td>  
				   <td>${orderDesc.customerAddress}</td>  
				   <td>${orderDesc.customerPhoneNumber}</td>
				   <td>${orderDesc.customerEmailId}</td> 
				   <td>${orderDesc.totalQuantity}</td>  
				   <td>${orderDesc.totalCost}</td>
				   <td>${orderDesc.orderDate}</td>
				   
				   <td>
				    <form:form method="post" action="viewSpecificOrder">
				    	<input type="hidden" value="${orderDesc.orderId}" name="orderId"/>  
				    	<input type="hidden" value="${orderDesc.userName}" name="userName"/>  
				       <input type="hidden" value="${orderDesc.customerName}" name="customerName"/>     
				       <input type="hidden" value="${orderDesc.customerAddress}" name="customerAddress"/>  
				    	<input type="hidden" value="${orderDesc.customerPhoneNumber}" name="customerPhoneNumber"/>  
				       <input type="hidden" value="${orderDesc.customerEmailId}" name="customerEmailId"/>     
				       <input type="hidden" value="${orderDesc.totalQuantity}" name="totalQuantity"/>  
				    	<input type="hidden" value="${orderDesc.totalCost}" name="totalCost"/>  
				       <input type="hidden" value="${orderDesc.orderDate}" name="orderDate"/>  
				       <input type="hidden" value="${orderDesc.productIds}" name="productIds"/>  
				       <input type="hidden" value="${orderDesc.productQuantities}" name="productQuantities"/>  
				      <input type="submit" value="View" />     
				   </form:form>
				   
				   
				   </td>
					<% }%>
   
   </tr>  
   </c:forEach>  
   </table>  
   </body>