<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s
}

.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

#main {
    transition: margin-left .5s;
    padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
</script>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <ul>
                <li>Menu</li>
              
                <li>
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">Product Categories</a>
                    <ul id="submenu1" class="ddsubmenustyle">
                    <li><a href="viewProducts">All products</a></li>
						<li><a href="${pageContext.request.contextPath}/viewProducts?code=1">Tv</a></li>
<li><a href="${pageContext.request.contextPath}/viewProducts?code=2">Fridge</a></li>
<li><a href="${pageContext.request.contextPath}/viewProducts?code=3">Washing Machine</a></li>
<li><a href="${pageContext.request.contextPath}/viewProducts?code=4">Laptops</a></li>
<li><a href="${pageContext.request.contextPath}/viewProducts?code=5">Air-Conditioners</a></li>
					</ul>
                </li>
                <li>
                    <a href="viewCart">My Cart</a>
                </li>
                <li>
                    <a href="#">About Us</a>
                </li>
                <li>
                    <a href="#">Contact Us</a>
                </li>
                
            </ul>

</div>

<div id="main" align="center">
  <!-- h2>Online Shopping</h2> -->
  <!-- <p>Enjoy your Shopping Experience !</p> -->
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open menu</span>
</div>


     
</body>
</html>

    