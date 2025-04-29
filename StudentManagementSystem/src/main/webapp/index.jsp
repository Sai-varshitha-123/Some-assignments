<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ page import="models.Student, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Mangement App</h1>
	<a href="addUsers.jsp">Add Users +</a>
	<table border="2">
	<thead>
		<tr>
		<th>email</th>
		<th>name</th>
		<th>age</th>
		<th>Actions</th>
		</tr>
	</thead>
		<tbody>
		
		<c:forEach var="student" items="${students}">
		<tr>
				<td>${student.email}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>
					<a>Edit</a>
					<a  href="Delete?email=${student.email}">Delete</a>
				</td>
				</tr>
		</c:forEach>
		
		</tbody>
	</table>
</body>
</html>