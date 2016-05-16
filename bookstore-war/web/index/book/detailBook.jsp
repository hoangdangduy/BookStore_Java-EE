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
        <!--        <script type="text/javascript" src="../../js/jquery-1.9.0.min.js"></script> 
                <script type="text/javascript" src="../../js/move-top.js"></script>
                <script type="text/javascript" src="../../js/easing.js"></script>-->
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
                        <th style="color:#ffffff;">Chi tiết sách</th>
                    </tr>
                </thead>

            </table>
        </div>  

        <div class="container">

            <%
                int idBook = Integer.parseInt(request.getParameter("idBook"));
                InitialContext ctx = new InitialContext();
                BookFacadeLocal bookFacadeLocal = (BookFacadeLocal) ctx.lookup("java:comp/env/BookFacade");
                Book book = bookFacadeLocal.find(idBook);
            %>

            <div row="class">
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-xs-6 col-md-4">
                            <img src="../../imageBook/<%=book.getImage()%>" class="img-rounded" alt="Cinque Terre" > 
                        </div>
                        <div class="col-xs-6 col-md-7" style="margin-left:45px">

                            <table class="table">

                                <tbody>
                                    <tr>
                                        <td><b>Tên sách:</b> <font color="#EE7600"><%=book.getTitle()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Giá:</b> <font color="#EE7600">$<%=book.getOriginalprice()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Năm xuất bản:</b> <font color="#EE7600"><%=book.getPublishyear()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Nhà xuất bản:</b> <font color="#EE7600"><%=book.getPublisher()%></font></td>
                                    </tr>
                                    <tr>
                                        <td><b>Tác giả:</b> <font color="#EE7600"><%=book.getAuthor()%></font></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <b>Số lượng:</b>
                                            <input type="number" id="qta_field" class="text_box" min="1" max="100" required class="col-xs-2">

                                            <script type="text/javascript">

                                                $(document).ready(function () {
                                                    $('a#id1').click(function (e) {
                                                        var bla = $('#qta_field').val();
                                                        if (isNaN(bla) == true) {
                                                            window.location.href = "../../AddToCart?method=get&idBook=<%=book.getIdBook()%>";
                                                            window.stop();
                                                        }

                                                        a = document.querySelector('a#id1');
                                                        a.setAttribute('href', a.getAttribute('href') + bla);

                                                    });
                                                });

                                            </script>	
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <!--<button type="button" class="btn btn-default">-->
                                            <%if (session.getAttribute("username") != null) {%>
                                                <span><a id="id1" class="btn btn-warning" style=" border-radius:0; background-color: #EE7600;" role="button" href="/bookstore-war/AddToCart?method=get&idBook=<%=book.getIdBook()%>&quantity=">Add to Cart</a>
                                            <%}  %>
                                                    <!--</button>-->

                                                    </td>
                                                    </tr>
                                                    </tbody>
                                                    </table>
                                                    </div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <table class="table" style="background-color: #f6f9c8; margin-left: 15px"> 
                                                            <thead>
                                                                <tr>
                                                                    <th style="color:#202020;">
                                                                        <p><%=book.getDescription()%></p>
                                                                    </th>
                                                                </tr>
                                                            </thead>

                                                        </table>
                                                    </div>
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

                                                            bookFacadeLocal = (BookFacadeLocal) ctx.lookup("java:comp/env/BookFacade");
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
