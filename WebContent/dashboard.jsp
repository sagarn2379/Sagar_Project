<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%User user = (User) session.getAttribute("loginUser"); 
%>
<h3>Welcome, <%=user.getFname()%><br></h3>
<strong>Your Email</strong>: <%=user.getEmail() %><br>
<strong>Your Telephone</strong>: <%=user.getTelephone()%><br>

<br>

    <form action="editUser.jsp" method="post">
    <%session.setAttribute("User", user);%>
Click here to update your profile<input type="submit" value="Update">
</form>
<div>
<form action="CrudUser" method="post">
<% session.setAttribute("Operation", "delete"); %>
<% session.setAttribute("email", user.getEmail());%>
Click here to delete your profile<input type="submit" value="Delete">

</form>
</div>
<div>
<table border = "1">
<tr>
<th> Application ID</th>
<th> Application Name </th>
<th> Application Desc </th>
</tr>
<c:forEach items="<%=user.getApplist() %>" var="app">
    <tr>
        <td><c:out value="${app.getID()}"/></td>
        <td> <c:out value="${app.getAppName()}"/></td>  
         <td> <c:out value="${app.getAppDesc()}"/></td> 
    </tr>
</c:forEach>
</table>

</div>
<div >

<form action="ApplicationController" method="post">
<% session.setAttribute("email", user.getEmail());%>
 <fieldset>
  <legend>Register Application:</legend>
  Application Name: <input type="text" name="appname"><br>
  Application Description: <textarea rows="4" cols="50" name="appdesc"> </textarea><br>
 <input type="submit" value="Register">

 </fieldset>
</form>
</div>

Click here to <a href= "/Sagar_Project/logout.html" ><button>Logout</button></a>
</body>
</html>