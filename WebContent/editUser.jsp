<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<div id="container">
<h2>SIGN UP </h2>
<%User user = (User) session.getAttribute("loginUser");
 %>

<form action="CrudUser" method="post">
 <fieldset>
  <legend>Edit User</legend>
<strong>First Name *: </strong><input type="text" name="fname" required="required" value="<%=user.getFname()%>"><br>
<strong>Last Name : </strong><input type="text" name="lname" value="<%=user.getLname()%>"><br>
<strong>Email ID *: </strong><input type="email" name="email" readonly="readonly" value="<%=user.getEmail()%>"><br>
<strong>Password *: </strong><input type="password" name="password" required="required" value="<%=user.getPassword()%>"><br>
<strong>Telephone : </strong><input type="text" name="phone" value="<%=user.getTelephone()%>"><br>
<% session.setAttribute("Operation", "edit") ;%>
<input type="submit" value="Update">
</fieldset>
</form>
<br>
</div>
</body>
</html>