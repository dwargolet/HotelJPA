<%-- 
    Document   : redirect
    Created on : Mar 2, 2015, 7:00:15 PM
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
            response.sendRedirect(request.getContextPath() + "/HotelController2");
        %>
    </body>
</html>
