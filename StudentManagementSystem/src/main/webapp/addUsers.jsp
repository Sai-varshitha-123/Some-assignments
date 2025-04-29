<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="StudentServlet" method="post">
    <label>Name:</label>
   	<input type="text" name="name" required><br>
  
    <label>Email</label>
    <input type="text" name="email" required><br>
    
    <label>Age:</label>
    <input type="number" name="age" required><br>
  
   	 <button type="submit">Add Student</button>
</form>
 
</body>
</html>