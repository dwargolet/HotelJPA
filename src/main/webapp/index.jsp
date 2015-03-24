<%-- 
    Document   : index
    Created on : Mar 3, 2015, 11:27:53 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel JPA</title>
        <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/styles.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <nav id="head" class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-inner navbar-content-center">
                <h3>Hotel Lab - <i>JPA Version</i></h3>
                <ul class="nav nav-tabs custom">
                    <li role="presentation" class="active"><a href="<%= request.getContextPath() %>/index.jsp">Main</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/Views/search.jsp">Search Records</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/Views/redirect.jsp">Records</a></li>
                </ul>    
            </div>
        </nav>
                
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="<%= request.getContextPath() %>/javascript/js.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>                 
    </body>
</html>
