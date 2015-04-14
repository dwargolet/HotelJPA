
<%@page import="hotel.entity.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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
            <div id="nav" class="navbar-inner navbar-content-center">
<!--                <h3>Hotel Lab - <i>JPA Version</i></h3>-->
                <ul class="nav nav-tabs custom">
                    <li role="presentation"><a href="<%= request.getContextPath() %>/index.jsp">Main</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/emailSignUp.jsp">Email</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/Views/searchRedirect.jsp">Search Records</a></li>
                    <li role="presentation" class="active"><a href="<%= request.getContextPath() %>/Views/redirect.jsp">Records</a></li>
                </ul>    
            </div>
        </nav>       
        
         <div class="container">
            <div class="row">           
                <div class="col-sm-4"> 
                    <c:forEach var="hotel" items="${hotelList}">
                        <table class="table table-condensed" id="recordListTable">
                            <thead style="border: 2px solid red;">
                                <th>ID</th>
                                <br>
                                <th>Name</th>                                                                                               
                            </thead>
                            <tbody>
                                <tr>                                    
                                    <td align="center">${hotel.hotelId}-</td>
                                   <td align="center"><input type="hidden" id="listedHotelName" value="${hotel.hotelName}"/>${hotel.hotelName}</td><br>
                                   <td align="center"><input type="hidden" id="listedHotelAddress" value="${hotel.streetAddress}"/>${hotel.streetAddress}</td>
                                   <td align="center"><input type="hidden" id="listedHotelCity" value="${hotel.city}"/>${hotel.city}</td>
                                    <td align="center"><input type="hidden" id="listedHotelState" value="${hotel.custState}"/>${hotel.custState}</td>
                                    <td align="center"><input type="hidden" id="listedHotelZip" value="${hotel.zip}"/>${hotel.zip}</td>
                                    <td align="center"><input type="hidden" id="listedHotelNote" value="${hotel.notes}"/>${hotel.notes}</td>
                                    <td align="center"><input type="radio" id="listedHotelRadio" name="hotelRadio" value="${hotel.hotelId}"/></td>
                                </tr>
                            </tbody>    
                        </table>               
                    </c:forEach>
                </div>    
            </div>
         </div>
        
        <div class="form-group">
            <form id="createRecord" name="createRecord"  method="POST" action="<%= request.getContextPath() %>/HotelController?action=create">
                <a name="createForm"></a>
                <div class="form-control">
                    <input type="text" name="hotelId" id="hotelId" placeholder="Hotel ID"/>
                </div> 
                <div class="form-control">
                    <input type="text"  id="hotelName" name="hotelName" placeholder="Hotel Name"/>
                </div> 
                <div class="form-control">
                    <input type="text" id="hotelAddress" name="hotelAddress" required="required" placeholder="Address"/>
                </div>
                <div class="form-control">
                    <input type="text" id="hotelCity" name="hotelCity" required="required" placeholder="City"/>
                </div>
                <div class="form-control">
                    <input type="text" id="hotelState" name="hotelState" min="2" required="required" placeholder="State"/>
                </div>
                <div class="form-control">
                    <input type="number" id="hotelZip" name="hotelZip"  class="numReqd" required="required" placeholder="Zip"/>
                </div>
                <div class="form-control">
                    <input type="textarea" id="hotelNote" name="hotelNote" placeholder="Notes"/>
                </div>           
  
                <input type="button" value="Create Record" id="createBtn" class="btn btn-primary btn-sm" name="createBtn" >
            </form>
        </div>
          

                
    <nav id="foot" class="navbar navbar-default navbar-fixed-bottom">
            <div class="navbar-inner navbar-content-center">
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <button class="btn btn-danger btn-md" type="submit" id="deleteBtn"><i>Delete Record</i></button>
                    <button class="btn btn-success btn-md" type="submit" id="editBtn"><i>Edit Record</i></button>               
                    <a class="btn btn-primary btn-md" href="#createForm" role="button" id="gotoBtn">Create Record</a>
                </sec:authorize>
            </div>
        <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
                Logged in as: <sec:authentication property="principal.username"></sec:authentication> ::
                <a href='<%= this.getServletContext().getContextPath() + "/j_spring_security_logout"%>'>Log Me Out</a>
        </sec:authorize>
    </nav>
                
                
            
                
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="resources/js/jquery-sortable-min.js "></script>
<script src="<%= request.getContextPath() %>/javascript/js.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>      
    </body>
</html>