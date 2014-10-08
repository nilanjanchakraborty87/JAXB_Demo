<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JAXB Example</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/cover.css" rel="stylesheet">

    </head>
    <body>
        <div class="site-wrapper">

            <div class="site-wrapper-inner">

                <div class="cover-container">

                    <div class="masthead clearfix">
                        <div class="inner">
                            <h3 class="masthead-brand">JAXB Client Login</h3>
                            <ul class="nav masthead-nav">
                                <li class="active"><a href="index.jsp">Home</a></li>
                                <li><a href="about.jsp">About</a></li>
                            </ul>
                        </div>
                    </div>

                    <div id="login" class="inner cover">
                        <h3 class="cover-heading pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Login:</h3>
                        <div class="row">
                            <div class="col-lg-offset-1 col-lg-10">
                                <form id="form1" class="form-inline" action="UserServlet?method=login" method=post>
                                    <label class="sr-only" for="Username">Username</label> 
                                    <div class="input-group">
                                        <input name="username" type="text" class="form-control" placeholder="Enter Username">
                                    </div>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <div class="input-group">
                                        <label class="sr-only" for="Password">Password</label>
                                        <input name="password" type="password" class="form-control" placeholder="Enter Password"> 
                                    </div>
                                    <div class="input-group">     
                                        <button class="btn btn-primary" type="submit">Login</button>
                                    </div> 

                                    <div class="input-group pull-right">     
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Sign Up</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    </div>
                                </form>

                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                <h4 class="modal-title" id="myModalLabel" >Sign Up</h4>
                                            </div>
                                            <form role="form" class="form" action="UserServlet?method=register" method=post>
                                                <div class="modal-body">

                                                    <div class="input-group">
                                                        <label class="label-s1" for="Username">Username: </label>
                                                        <input name="username" type="text" class="form-control" placeholder="Enter Username">
                                                    </div><br/>
                                                    <div class="input-group">
                                                        <label class="label-s1" for="Password">Password: </label>
                                                        <input name="password" type="text" class="form-control" placeholder="Enter Password">
                                                    </div><br/>
                                                    <div class="input-group">
                                                        <label class="label-s1" for="Email">Email: </label>
                                                        <input name="email" type="text" class="form-control" placeholder="Enter Email">
                                                    </div><br/>
                                                    <div class="input-group">
                                                        <label class="label-s1" for="First_Name">First Name: </label>
                                                        <input name="first_name" type="text" class="form-control" placeholder="Enter First Name">
                                                    </div><br/>
                                                    <div class="input-group">
                                                        <label class="label-s1" for="Last_Name">Last Name: </label>
                                                        <input name="last_name" type="text" class="form-control" placeholder="Enter Last Name">
                                                    </div><br/>
                                                    <div class="input-group">
                                                        <label class="label-s1" for="Birth_Year">Birth Year: </label>
                                                        <input name="birth_year" type="text" class="form-control" placeholder="Enter Birth Year">
                                                    </div><br/>
                                                    <div class="input-group">
                                                        <label class="label-s1" for="Birth_Month">Birth Month: </label>
                                                        <input name="birth_month" type="text" class="form-control" placeholder="Enter Birth Month">
                                                    </div>



                                                </div>
                                                <div class="modal-footer">
                                                    <div class="input-group pull-right">     
                                                        <button class="btn btn-primary" type="submit">Register</button>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                                <%String error = (String) request.getAttribute("error");
                                    if (error != null) {%>
                                <h4 style="color: #FF6633"><%=error%></h4><%}%>
                            </div>
                        </div>

                    </div>

                    <div class="mastfoot">
                        <div class="inner">
                            <p>Copyright @ Rui Bi</p>
                        </div>
                    </div>

                </div>

            </div>

        </div>



        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
