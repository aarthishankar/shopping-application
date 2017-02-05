<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
<style>
table {
  border-collapse: separate;
  border-spacing: 0;
  margin-left:35%; 
    margin-right:15%;
    margin-top:10%;
}
th,
td {
  padding: 10px 15px;
}
thead {
  background: #395870;
  color: #fff;
}
tbody tr:nth-child(even) {
  background: #f0f0f2;
}
td {
  border-bottom: 1px solid #cecfd5;
  border-right: 1px solid #cecfd5;
}
td:first-child {
  border-left: 1px solid #cecfd5;
}

</style> 


	  <script>
	function getFilePath() {
	    var x = document.getElementById("filePathExtraction").value;
	    document.getElementById("filePath").value=x;
	}
	</script>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>  
       <form:form method="post" action="editTheProduct">    
        <table>    
         <tr>    
          <td>Product Id : </td>   
          <td><%
          
          String pid=request.getParameter("productId").toString();
          out.println(pid);%>
          <form:input path="productId" type="hidden" value="<%=pid%>" />
          </td>  
         </tr>    
         <tr>    
          <td>Product Name :</td>    
          <td><form:input required="required" path="productName" type="text" /></td>  
         </tr>   
         <tr>    
          <td>Product Price :</td>    
          <td><form:input required="required" path="productPrice" name="price" type="number" min="0" /></td>  
         </tr> 
         <tr>    
          <td>Product Quantity :</td>    
          <td><form:input required="required" path="productQuantity" type="number" min="0" /></td>  
         </tr> 
         <tr>    
          <td>Product Image :</td>    
          <td><form:input path="productImage" type="file" id="filePathExtraction" /></td> 
          <td>  <input type="hidden" id="filePath" name="filePath"></td> 
         </tr>   
         <tr>    
          <td colspan="2"><input type="submit" value="Update" /></td>    
         </tr>    
        </table>    
       </form:form>   
       </body>
       </html> 