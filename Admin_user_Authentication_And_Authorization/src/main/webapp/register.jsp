<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <form action ="register" method ="post">
  <h1 >Register here....</h1>
      NAME : <input type ="text" placeholder ="enter a name" name ="name">
  <br>
  <br>
   USERNAME : <input type ="text" placeholder ="enter a userid" name ="userId">
  <br>
  <br>
    PASSWORD: <input type="password" name ="password" placeholder ="enter password">
   <br>
  <br>
   
   <input type ="radio" value ="1" name ="id" > Admin
   <input type ="radio" value ="2" name ="id" > user
     <br>
     <br>
  <button value="submit"> submit</button>
 </form>

</body>
</html>