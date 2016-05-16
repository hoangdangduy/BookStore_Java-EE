<%@page import="javax.ejb.EJB"%>
<%@page import="entities.Book"%>
<%@page import="java.util.List"%>
<%@page import="sessionbean.BookFacadeLocal"%>
<%@page import="javax.naming.InitialContext"%>
<!DOCTYPE html>
<html lang="en">
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <head>
        <title>Bootstrap Example</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
                        <form action="/bookstore-war/SearchBook" method="post" class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search" name="searchBook">
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

        

        <br><br>

        <div class="container text-center"  >  
            <table class="table" style="background-color: #EE7600; "> 
                <thead>
                    <tr>
                        <th style="color:#ffffff;">    NEW PRODUCT</th>
                    </tr>
                </thead>

            </table>
        </div>  

        <div class="container text-center" >  
            <div class = "row">


                <%
                    List<Book> listBook = (List<Book>) session.getAttribute("listBookSearch");
                    for (int i = 0; i < listBook.size(); i++) {%>
                <div class = "col-sm-6 col-md-3">
                    <div class = "thumbnail">
                        <img src = "../../imageBook/<%=listBook.get(i).getImage()%>" alt = "Generic placeholder thumbnail" >
                        <div class = "caption">
                            <p><%=listBook.get(i).getTitle()%></p>

                            <p>
                                <span>
                                    Giá: $<%=listBook.get(i).getOriginalprice()%>
                                </span>

<!--                                <a href = "#" class = "btn btn-warning" style=" border-radius:0;" role = "button">
                                    Add to cart
                                </a>-->
                                <a href="/bookstore-war/index/book/detailBook.jsp?idBook=<%=listBook.get(i).getIdBook()%>" 
                                   class = "btn btn-warning" style=" border-radius:0;" role = "button">Add to Cart</a>
                            </p>

                        </div>
                    </div>


                </div>
                <% }%>
            </div>

        </div>

        <div class="navbar-fixed-bottom row-fluid" style="background-color: #101010">  
            <include src="footer.html"></include>
            <div w3-include-html="footer.html"></div>
            <jsp:include page="../home/footer.html" />
            <%--<%@include file="../home/footer.html" %>--%>
        </div>

    </body>
</html>
