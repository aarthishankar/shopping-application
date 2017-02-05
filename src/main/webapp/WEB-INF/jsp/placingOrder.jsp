<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
   <%@ page import="java.io.*,java.util.*"%>
   <%@page import="com.saproject.onlineshop.dao.impl.ProductDAOImpl"%>
   <%@page import="com.saproject.onlineshop.entity.ProductCart"%>
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
   <script type="text/javascript">
        function Validate()
        {
            //var x = document.form1.txtPhone.value;
            var x = document.getElementById("phno").value;
           if(isNaN(x)||x.indexOf(" ")!=-1)
           {
              alert("Enter numeric value in phone number");
              return false; 
           }
           if (x.length>10 || x.length<6)
           {
                alert("not a valid phone number");
                return false;
           }
        }

        function onlyAlphabets(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
        }
        </script>
      <form:form method="post" action="saveOrder">    
        <table >    
         <tr>    
          <td>Customer Name : </td>   
          <td><form:input  required="required" path="customerName" onkeypress="return onlyAlphabets(event,this);"/></td>  
         </tr>    
         <tr>    
          <td>Customer Email-Id :</td>    
          <td><form:input required="required" path="customerEmailId" type="email" /></td>  
         </tr>   
         <tr>    
          <td>Customer Phone Number :</td>    
          <td><form:input required="required" path="customerPhoneNumber" id="phno" name="phno"/></td>  
         </tr> 
         <tr>    
          <td>Customer Address :</td>    
          <td><form:input required="required" path="customerAddress" onkeypress="return onlyAlphabets(event,this);"/></td>  
         </tr>
         <tr>
			<td>			  <table border="2" width="70%" cellpadding="2">  
						   <tr><th>Product Image</th><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Total Price</th></tr>  
						   <% int totalCost=0;
						   	int totalQuantity=0;
						   	String product_ids="";
						   	String product_quantities="";
				         	ProductDAOImpl productDAOImpl=new ProductDAOImpl();
				         	 List<ProductCart> list;
				 	    	list=productDAOImpl.viewProductsCart(); 
				         	
						   %>
						   <c:forEach var="productCart" items="<%=list%>">   
					 	      
						   <tr>  
						   <td><ul style="list-style: none;"><li><img src="Image Resources/Product Images/code_${productCart.productId}.jpg" /></li></ul></td> 
						   <td>${productCart.productId}</td>  
						   <td>${productCart.productName}</td>  
						   <td>${productCart.productPrice}</td>  
						   <td>${productCart.productQuantity}</td>
						   <td>
						    <c:set var="productPrice" value= "${productCart.productPrice}"/>
						     <c:set var="productId" value= "${productCart.productId}"/>
						    <c:set var="productQuantity" value= "${productCart.productQuantity}"/>
						    <%
						    String productPriceString = "";
						    productPriceString = productPriceString+pageContext.getAttribute("productPrice");
						    String productQuantityString = "";
						    productQuantityString = productQuantityString+pageContext.getAttribute("productQuantity");
						    String productIdString = "";
						    productIdString = productIdString+pageContext.getAttribute("productId");
						    int totalPrice=0;
						    int productPrice=Integer.parseInt(productPriceString);
						    int productQuantity=Integer.parseInt(productQuantityString);
						    totalPrice=productPrice*productQuantity;
						    out.println(totalPrice);
						    totalCost=totalCost+totalPrice;
						    totalQuantity=totalQuantity+productQuantity;
						    product_ids=product_ids+"_"+productIdString;
						    product_quantities=product_quantities+"_"+productQuantityString;
						    %>
						   </td>
													  
						   </tr>  
						   </c:forEach>
						   <tr>
						   <td colspan="2"></td>
						   <td>Total Quantity: </td>
						   <td><%out.println(totalQuantity);%></td>
						   <td>Total Cost: </td>
						   <td>Rs.<%out.println(totalCost);%></td>
						   </tr> 						   
						   </table>   
         
         	
         	
         	 
       		<form:input path="totalQuantity" type="hidden" value="<%=totalQuantity%>"/>
       		<form:input path="totalCost" type="hidden" value="<%=totalCost%>"/>
       		<form:input path="productIds" type="hidden" value="<%=product_ids%>"/>
       		<form:input path="productQuantities" type="hidden" value="<%=product_quantities%>"/>
       		 </td>
         </tr>
            
         <tr>    
          <td colspan="2"><input type="submit" value="Confirm And Place Order" onclick="return Validate()"/></td>    
         </tr>    
        </table>    
       </form:form>  
   		
   		
   		
   		
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
