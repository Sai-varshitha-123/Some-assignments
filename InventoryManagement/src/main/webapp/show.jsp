<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ page import="models.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


<%List<Goods> goods=(List<Goods>) request.getAttribute("goods"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stored Goods</title>
</head>
<body>
	<table border="1px">
		<thead>
		 <tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
	    </thead>
	    <c:forEach var="item" items="${goods}">
	    	<tr>
	    		<td>${item.getId()}</td>
	    		<td>${item.getName()}</td>
	    		<td>${item.getDesc()}</td>
	    		<td>${item.getPrice()}</td>
	    		<td><a href="HandleOpp?id=${item.id}&action=edit">Edit</a> <a href="HandleOpp?id=${item.id}&action=delete">Delete</a></td>
	    	</tr>
	    </c:forEach>
			
	</table>
	
	<a href="index.jsp">Go To Home</a>

	

</body>
</html>