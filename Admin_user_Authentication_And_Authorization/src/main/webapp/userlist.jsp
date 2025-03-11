<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
   ArrayList<String > ls = (ArrayList<String>) request.getAttribute("dlist");
   for(String em1 :ls){ %>
      <a href ="user.jsp"><%= em1 %></a>
     
   <%
   out.println("<br>");
   } %>
</body>
</html>