<%-- 
    Document   : login
    Created on : Mar 31, 2015, 2:09:05 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel JPA - Login</title>
        <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/styles.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <nav id="head" class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-inner navbar-content-center">
                <h3>Hotel Lab - <i>JPA Version</i></h3>               
            </div>
        </nav>
        
        
        
        <div class="container">
            <form id="signInForm" role="form" method='POST' action="<c:url value='j_spring_security_check' />">
                <div class="col-sm-6">
                    <h3 style="font-weight: 200;">Sign in </h3>
                    <div class="form-group">
                        <input tabindex="1" class="form-control" id="j_username" name="j_username" placeholder="Email address" type="text" autofocus />
                        <input tabindex="2" class="form-control" id="j_password" name="j_password" type="Password" placeholder="password" />
                    </div>
                    <div class="form-group">
                        <input class="btn btn-warning" name="submit" type="submit" value="Sign in" />
                    </div>
                </div>
            </form>
        </div>        
    </body>
</html>
