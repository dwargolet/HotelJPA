<%-- 
    Document   : searchRedirect
    Created on : Apr 9, 2015, 1:33:24 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirect</title>
    </head>
    <body>
        <%
            response.sendRedirect(request.getContextPath() + "/SearchController");
        %>
        
    </body>
</html>
