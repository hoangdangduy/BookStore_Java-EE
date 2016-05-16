<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.BookOrder"%>
<%@page import="entities.Cart"%>
<%@page import="java.util.List"%>
<%@page import="entities.Book"%>
<%@page import="sessionbean.BookFacadeLocal"%>
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
        <script src="../../js/jquery-1.12.3.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <style>

        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
<!--                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>-->
                    <!--<a class="navbar-brand" href="#">Logo</a>-->
                    <img src="../../imageBook/logo1.jpg">
                </div>
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
                            <% } %>
                    </ul>
                </div>
            </div>
        </nav>




        <div class="container text-center"  >  
            <table class="table" style="background-color: #EE7600; "> 
                <thead>
                    <tr>
                        <th style="color:#ffffff;">Check out</th>
                    </tr>
                </thead>

            </table>
        </div>  

        <div class="container">
            <div row="class">
                <div class="col-md-8">
                    <%
                        Cart cart = (Cart) session.getAttribute("cart");
                        List<BookOrder> listBookOrder = cart.getBookOrderList();
                        for (int i = 0; i < listBookOrder.size(); i++) {
                    %>
                    <div class="row">
                        <div class="col-xs-6 col-md-4">
                            <img src="../../imageBook/<%=listBookOrder.get(i).getIdBook().getImage()%>" class="img-rounded" alt="Cinque Terre" > 
                        </div>
                        <div class="col-xs-6 col-md-7" style="margin-left:45px">

                            <table class="table">

                                <tbody>
                                    <tr>
                                        <td><b>Tên sách:</b> <font color="#EE7600"><%=listBookOrder.get(i).getIdBook().getTitle()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Giá:</b> <font color="#EE7600">$<%=listBookOrder.get(i).getIdBook().getOriginalprice()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Tác giả:</b> <font color="#EE7600"><%=listBookOrder.get(i).getIdBook().getAuthor()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Số lượng:</b> <font color="#EE7600"><%=listBookOrder.get(i).getQuantity()%></font></td> 
                                    </tr>
                                    <tr>
                                        <td><b>Tiền:</b> <font color="#EE7600">$<%=listBookOrder.get(i).getTotalPrice()%></font></td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <button class="btn btn-default center-block" style="text-align: center; background-color: #EE7600; ">
                                                <a style="color:#ffffff;" id="id1" href="../../UpdateCart?method=get&idBook=<%=listBookOrder.get(i).getIdBook().getIdBook()%>&isEdit=true&isRemove=false">Edit</a>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <button class="btn btn-default center-block" style="text-align: center; background-color: #EE7600; color:#ffffff;">
                                                <a style="color:#ffffff;" id="id1" href="../../UpdateCart?method=get&idBook=<%=listBookOrder.get(i).getIdBook().getIdBook()%>&isEdit=false&isRemove=true">Remove</a>
                                            </button>
                                        </td>
                                    </tr>


                                </tbody>
                            </table>
                        </div>
                    </div>
                    <% } %>

                    <hr>
                    <% if (listBookOrder.size() > 0){ %>
                    <p align="center"><a href="/bookstore-war/index/orders/addressShipping.jsp" class = "btn btn-warning text-center" style=" border-radius:0; background-color: #EE7600;" role = "button">Send Order</a></p>
                    <% } %>
                </div>
                <div class="col-md-3" style="margin-left: 75px">
                    <table class="table" style="background-color: #EE7600; "> 
                        <thead>
                            <tr>
                                <th style="color:#ffffff;">GIẢM GIÁ NHẤT</th>
                            </tr>
                        </thead>
                    </table>

                    <%
                        InitialContext ctx = new InitialContext();
                        BookFacadeLocal bookFacadeLocal = (BookFacadeLocal) ctx.lookup("java:comp/env/BookFacade");
                        List<Book> listBook = (List<Book>) bookFacadeLocal.findAll();
                        for (int i = 0; i < listBook.size(); i++) {
                    %>

                    <div class = "thumbnail text-center">
                        <img src = "../../imageBook/<%=listBook.get(i).getImage()%>" alt = "Generic placeholder thumbnail" >
                        <div class = "caption">
                            <p><%=listBook.get(i).getTitle()%></p>

                            <p>
                                <span>
                                    Giá: $<%=listBook.get(i).getOriginalprice()%>
                                </span>

                                <a href="/bookstore-war/index/book/detailBook.jsp?idBook=<%=listBook.get(i).getIdBook()%>" 
                                   class = "btn btn-warning" style=" border-radius:0; background-color: #EE7600;" role = "button">Add to Cart</a>
                            </p>

                        </div>
                    </div>

                    <% }%>

                </div>
            </div>
        </div>  

        <div class="container-fluid text-center" style="background-color: #101010">  
            <include src="footer.html"></include>
            <div w3-include-html="footer.html"></div>
        </div>

    </body>
</html>
