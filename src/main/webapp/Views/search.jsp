<%-- 
    Document   : search
    Created on : Mar 23, 2015, 9:38:23 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/styles.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <nav id="head" class="navbar navbar-default navbar-fixed-top">
            <div id="nav" class="navbar-inner navbar-content-center">
                <h3>Hotel Lab - <i>JPA Version</i></h3>
                <ul class="nav nav-tabs custom">
                    <li role="presentation"><a href="<%= request.getContextPath() %>/index.jsp">Main</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/emailSignUp.jsp">Email</a></li>
                    <li role="presentation"><a href="<%= request.getContextPath() %>/Views/searchRedirect.jsp">Search Records</a></li>
                    <li role="presentation" class="active"><a href="<%= request.getContextPath() %>/Views/redirect.jsp">Records</a></li>
                </ul>    
            </div>
        </nav>
        
        <div class="container">
        
            <h1>Search hotels</h1>
            <select id="searchOptions">
                <option value="" selected="selected">Search by:</option>
                <option value="0">Find all hotels</option>
                <option value="1">Find by state</option>
                <option value="2">Find by city</option>
            </select>
            <form action="SearchWizard" method="POST" action="<%= request.getContextPath() %>/HotelController2?action=search">
                <div class="input-field">
                    <input class="stateInput" type="text" name="state" id="state" hidden="hidden">
                    <label class="stateInput" hidden="hidden" for="state">State</label>
                </div>
                <div class="input-field">
                    <input class="cityInput" type="text" name="city" id="city" hidden="hidden">
                    <label class="CityInput" hidden="hidden" for="city">City</label>
                </div>
                <input type="button" value="Search" id="searchBtn" class="btn btn-primary btn-sm" name="searchBtn" >
            </form>
                <br>
                
                
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="<%= request.getContextPath() %>/javascript/js.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script> 
        
        
    </body>
</html>
