<html>
<head>
<!-- <style>
ol {
    background: #ff9999;
    padding: 20px;
}

ul {
    background: #3399ff;
    padding: 20px;
}

ol li {
    background: #ffe5e5;
    padding: 5px;
    margin-left: 35px;
}

ul li {
    background: #cce5ff;
    margin: 5px;
}
</style> -->
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>  
 <jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>   
<%-- Message is: ${msg} --%>
<br/>
<center>
<br/>

<ul style="list-style: none">

<%
String nameOfTheUser=session.getAttribute("nameOfTheUser").toString();
if(nameOfTheUser.equals("admin"))
{
%>
<li><h3><i><a href="addProduct">Add a Product</a></i></h3></li>
<br/>
<li><h3><i><a href="viewCustomers">View Accounts</a></i></h3></li>
<br/>
<%} %>
<!-- <li><h3><i><a href="viewProducts">View All Products</a></i></h3></li> -->
<br/>
<h4><b>Click here to view orders</b></h4>
<br/>
<li><h3><i><a href="viewOrders">View Orders</a></i></h3></li>
<br/>
<!-- <li><h3><i> <a href="viewCart">View MyCart</a></i></h3></li> -->

</ul> 
</center>

</body>
</html>