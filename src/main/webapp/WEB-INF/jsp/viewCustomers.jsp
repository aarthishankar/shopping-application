<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <html>
   <head>
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
<tr><th>Id</th><th>UserName</th><th>Password</th><th>Role</th><th></th></tr>  
   <c:forEach var="cust" items="${list}">   
   <tr>  
   <td>${cust.userId}</td>  
   <td>${cust.userName}</td>  
   <td>${cust.password}</td>  
   <td>${cust.role}</td>
    <c:set var="userName" value= "${cust.userName}"/>
    <%
    String userName = "";
   userName = userName+pageContext.getAttribute("userName");
   if(!(userName.equals("admin")))
   {
   %>
   <td>
   <form:form method="post" action="deleteAccount"> 
       <input type="hidden" value="${cust.userId}" name="userId"/>         
      <input type="submit" value="Delete" />     
   </form:form>
   </td>
   <%} %>  
   </tr>  
   </c:forEach>  
   </table> 
   </body>  
   </html> 