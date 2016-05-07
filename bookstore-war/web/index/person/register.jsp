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

        <!--<nav class="navbar navbar-inverse">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
              </button>
              <a class="navbar-brand" href="#">Logo</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Contact</a></li>
              </ul>
                 <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
              </form>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
              </ul>
            </div>
          </div>
        </nav>-->

        <nav class="navbar navbar-inverse">
            <div class="container">
                <!--    <div class="navbar-header">
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
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                        <li><a href="../person/register.jsp"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
                        <li><a href="../person/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container text-center"  >  
            <table class="table" style="background-color: #EE7600; "> 
                <thead>
                    <tr>
                        <th style="color:#ffffff;">    Register</th>
                    </tr>
                </thead>

            </table>
        </div>  

        <div class="container ">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <form method="post" action="/bookstore-war/Register">
                        <div class="form-group">
                            <label >Username:</label>
                            <input type="input" class="form-control" name="username" >
                        </div>
                        <div class="form-group">
                            <label >Password</label>
                            <input type="password" class="form-control" name="password">
                        </div>
                        <div class="form-group">
                            <label >Fullname:</label>
                            <input type="input" class="form-control" name="fullname">
                        </div>
                        <div class="form-group">
                            <label >Email</label>
                            <input type="email" class="form-control"  name="email">
                        </div>
                        <div class="form-group">
                            <label >Num:</label>
                            <input type="input" class="form-control" name="num">
                        </div>
                        <div class="form-group">
                            <label >Ward</label>
                            <input type="input" class="form-control" name="ward">
                        </div>
                        <div class="form-group">
                            <label >District:</label>
                            <input type="input" class="form-control" name="district">
                        </div>
                        <div class="form-group">
                            <label >City:</label>
                            <input type="input" class="form-control" name="city">
                        </div>
                        <div class="form-group">
                            <label >Mobile phone:</label>
                            <input type="input" class="form-control" name="phonenum">
                        </div>
                        <button type="submit" class="btn btn-default center-block" style="text-align: center; background-color: #EE7600; color:#ffffff;" >Submit</button> 
                    </form>
                </div>
            </div>
        </div>  

        <div class="container-fluid text-center" style="background-color: #101010">  
            <include src="footer.html"></include>
            <div w3-include-html="footer.html"></div>
        </div>

    </body>
</html>
