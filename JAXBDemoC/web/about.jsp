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
        <title>Twitter Search</title>

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
                            <h3 class="masthead-brand">About JAXB</h3>
                            <ul class="nav masthead-nav">
                                <li><a href="index.jsp">Home</a></li>
                                <li class="active"><a href="about.jsp">About</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="inner">
                        <div class="row"><br/></div>
                        <div class="row">
                            <div class="col-lg-12">
                                <h3>My Procedure:</h3>
                                <h4>Service Part:</h4>
                                <h4>XML schema to Java class by JAXB</h4>
                                <h4>XML document as a data Storage</h4>
                                <h4>Two service operations: Login (Get UserInfo) and Register (Add UserInfo)</h4>
                                <h4>These two operation used Java class from schema and access the XML document to get info or add info</h4>
                                <h4>Client Part: </h4>
                                <h4>Using Servlet to call service operation and get response</h4>
                                <h4>If new user, sign up for new user</h4>
                                <h4>If fail authentication stay the login page and get warning</h4>
                                <h4>If succeed, return user information</h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <h3>Notice:</h3>
                                <h5>Test Account: Username: jack10; Password:jack</h5>
                                <h5>XML Document Path may occur some warning: </h5>
                                <h5>Please copy my XML document(com.schema.UserList.xml) into your glassfish file</h5>
                                <h5>(./glassfish/domains/domain1/config) *it may different in Windows machine*</h5>
                                
                            </div>
                        </div>
                    </div>

                  

                </div>

            </div>

        </div>






        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
