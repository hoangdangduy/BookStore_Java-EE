<%@page import="entities.Customer"%>
<%@page import="sessionbean.CustomerFacadeLocal"%>
<%@page import="javax.naming.InitialContext"%>
<!DOCTYPE html>
<html lang="en">
        <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="../..//js/bootstrap.min.js"></script>
  <style>
  
  </style>
</head>
<body>

 <nav class="navbar navbar-inverse">
            <div class="container">
                <!--                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>                        
                                    </button>
                                    <a class="navbar-brand" href="#">Logo</a>
                                </div>-->
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="../home/home.jsp">Home</a></li>
                        <!--        <li><a href="#">About</a></li>
                                <li><a href="#">Projects</a></li>
                                <li><a href="#">Contact</a></li>-->
                        <%if (session.getAttribute("username") == null) {%>
                        <%} else {%>
                        <li><a href="#">Hello <%=session.getAttribute("username")%></a></li>					
                        <!-- nhảy đến servlet xử lí log out -->						
                        <%if (session.getAttribute("cart") == null) {%>							
                        <li><a href="#">Check out</a></li>						
                            <%} else {%>						
                        <li><a href="../orders/checkOut.jsp">Check out</a></li>				
                            <%}%>
                        <li><a href="../person/editAddress.jsp">My account</a></li>
                            <%}%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                        <% if (session.getAttribute("username") == null) { %>
                        <li><a href="../person/register.jsp"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
                        <li><a href="../person/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                            <%} else { %>
                        <li><a href="/bookstore-war/Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                            <% }%>
                    </ul>
                </div>
            </div>
        </nav>
  
<div class = "container">
<div class="row">
  <div class="col-xs-6 col-md-3">
		<table class="table table-bordered" >
			 <thead>
				  <tr bgcolor="#EE7600">
					<th  style="color:#ffffff;" >Edit Account</th>
				  </tr>
			</thead>
			<tbody> 
			  <tr>
				<td bgcolor="#EBE8E8"><a href="../person/editAddress.jsp">Thay đổi địa chỉ</a></td>
			  </tr>
			  <tr>
                              <td bgcolor="#EBE8E8" class="active"><a href="#">Thay đổi điện thoại</a></td>
			  </tr>
			  <tr>
				<td bgcolor="#EBE8E8"><a href="../person/editPassword.jsp">Thay đổi mật khẩu</a></td>
			  </tr>
			  
			</tbody>
		  </table>
  </div>
  <div class="col-xs-12 col-sm-6 col-md-9	">
		<div class="col-md-6 col-md-offset-3">
                    
                        <%
                            Integer idPerson = (Integer) session.getAttribute("idPerson");
                            InitialContext ctx = new InitialContext();
                            CustomerFacadeLocal customerFacadeLocal = (CustomerFacadeLocal) ctx.lookup("java:comp/env/CustomerFacade");
                            Customer customer = customerFacadeLocal.find(idPerson);
                        %>
                        <form method="post" action="/bookstore-war/EditPhone">
				  <div class="form-group">
					<label>Phone:</label>
					<input type="input" class="form-control" placeholder="<%=customer.getPhonenum() %>" name="phone">
				  </div>
				  <div class="form-group">
					<label>Email:</label>
					<input type="email" class="form-control" placeholder="<%=customer.getEmail() %>" name="email">
				  </div>
				  <button type="submit" class="btn btn-default center-block" style="text-align: center; background-color: #EE7600; color:#ffffff;">Change</button> 
				</form>
		</div>
  </div>
</div>
</div>
  
  <br><br>
  

  



<div class="container-fluid text-center" style="background-color: #101010">  
	<include src="footer.html"></include>
	<div w3-include-html="footer.html"></div>
</div>

</body>
</html>
