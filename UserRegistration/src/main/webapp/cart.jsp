<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	 function showData()
	 {
		 var loggedInUser=sessionStorage.getItem("loggedInUser");
		 var storedData = JSON.parse(localStorage.getItem("id_" + loggedInUser));
	  	 //console.log(storedData);
	  	 
	  	 
	 }
	 
</script>
</head>
<body onload="showData()">
	<h1>hi</h1>
	
</body>
</html>