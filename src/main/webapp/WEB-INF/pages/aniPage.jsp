<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Animal Page</title>
</head>
<body>
	<spring:url value="/animals/add" var="addURL" />
	<a href="${addURL }">Add Animal</a>

	<h1>Animals List</h1>
	<table width="100%" border="1">
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Name</th>
			<th>Color</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${listAnimals }" var="animals">
			<tr>
				<td>${animals.animalid }</td>
				<td>${animals.type }</td>
				<td>${animals.name }</td>
				<td>${animals.color }</td>
				<td><spring:url
						value="/animals/update/${animals.type }" var="updateURL" />
					<a href="${updateURL }">Update</a></td>
				<td><spring:url
						value="/animals/delete/${employees.type }" var="deleteURL" />
					<a href="${deleteURL }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>