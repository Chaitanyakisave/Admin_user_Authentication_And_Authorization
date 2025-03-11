<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>hi am admin</h1>
  <h1><%= session.getAttribute("role") %></h1>
  <a href ="userlist">userlist</a>
</body>
</html>