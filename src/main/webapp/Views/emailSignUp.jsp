<%-- 
    Document   : emailSignUp
    Created on : Apr 14, 2015, 11:05:40 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Sign Up</title>
        <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/styles.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <nav id="head" class="navbar navbar-default navbar-fixed-top">
            <div id="nav" class="navbar-inner navbar-content-center">
<!--                <h3>Hotel Lab - <i>JPA Version</i></h3>-->
                <ul class="nav nav-tabs custom">
                    <li role="presentation"><a href="<%= request.getContextPath() %>/index.jsp">Main</a></li>
                    <li role="presentation" class="active"><a href="<%= request.getContextPath() %>/emailSignUp.jsp">Email</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/Views/searchRedirect.jsp">Search Records</a></li>
                    <li role="presentation" class="active"><a href="<%= request.getContextPath() %>/Views/redirect.jsp">Records</a></li>
                </ul>    
            </div>
        </nav>
                
       <div class="form-group">
            <form id="emailSignUp" name="emailSignUp"  method="POST" action="<%= request.getContextPath() %>/RegistrationController?action=create">
                <a name="createForm"></a>
                <div class="form-control">
                    <input type="text" name="firstName" id="firstName" placeholder="First Name"/>
                </div> 
                <div class="form-control">
                    <input type="text"  id="lastName" name="lastName" placeholder="Last Name"/>
                </div> 
                <div class="form-control">
                    <input type="text" id="emailAddress" name="emailAddress" required="required" placeholder="Email"/>
                </div>  
                <input type="button" value="Sign Up" id="emailSignUp" class="btn btn-primary btn-sm" name="emailSignUp" >
            </form>
        </div>         
                
                
                
                
                
                
                
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="resources/js/jquery-sortable-min.js "></script>
<script src="<%= request.getContextPath() %>/javascript/js.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>  
    </body>
</html>
