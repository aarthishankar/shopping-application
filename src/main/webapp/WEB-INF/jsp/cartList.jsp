<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <%@page import="com.saproject.onlineshop.dao.impl.ProductDAOImpl"%>
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
            var x = document.getElementById("productQuan").value;
            var storex = document.getElementById("storedProductQuan").value;
           if (x>10 || x<1)
           {
                alert("Enter quantity between 1 and 10");
                return false;
           }
           else if(parseInt(x,10)>parseInt(storex,10))
           {
        	   alert("Only "+storex+" items left and can be ordered");
               return false;
           }
        }
        </script>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>        
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product Image</th><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Total Price</th></tr>  
   <% int totalCost=0;
   int totalQuantity=0;
   %>
   
   <c:forEach var="productCart" items="${productCartlist}">   
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
    
    %>
   </td>
   <td>
   <form:form method="post" action="updateCart">
   	 <input type="hidden" name="productId" value="${productCart.productId}">  
   	  <input type="hidden" name="productName" value="${productCart.productName}">  
   	   <input type="hidden" name="productPrice" value="${productCart.productPrice}">
   	 <%
   	 ProductDAOImpl productDAOImpl=new ProductDAOImpl();
   	 int quan=productDAOImpl.getProductQuantityForId(productIdString);
   	 %>
   	 <input type="hidden" id="storedProductQuan" value="<%=quan%>" />
   	 <input type="number" name="productQuantity" id="productQuan" min="1"/>       
     <input type="submit" value="Update Quantity" onclick="return Validate()" />    
   </form:form>
   </td> 
   <td>
   <form:form method="post" action="deleteFromCart"> 
       <input type="hidden" value="${productCart.productId}" name="productId"/>         
      <input type="submit" value="Delete" />     
   </form:form>
   </td> 
   </tr>  
   </c:forEach>
   <tr>
   <td colspan="2"></td>
   <td>Total Quantity: </td>
   <td><%out.println(totalQuantity);%></td>
   <td>Total Cost: </td>
   <td colspan="3">Rs. <%out.println(totalCost);%></td>
   </tr> 
   <tr><td colspan="8">
   <form:form method="post" action="continueToProductList">        
      <input type="submit" value="Add More Products" />     
   </form:form>
   </td></tr> 
   
   
   
   <tr><td>
   <%
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
   		boolean result=productDAOImpl.checkIsProductsCartEmpty();
   		if(result==false)
   		{
   %>
   <a href="placingOrder">Place Order</a>
   <%}
   		else
   		{out.println("Your cart is empty. Add products to Place Order.");}%>
   </td></tr>
   </table> 