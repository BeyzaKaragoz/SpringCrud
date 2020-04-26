<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Animal Form</title>
</head>
<body>
	<spring:url value="/animals/save" var="saveURL" />
	<form:form modelAttribute="animalForm" method="post" action="${saveURL }">
		<form:hidden path="animalid" />
		<table>
			<tr>
				<td>Type:</td>
				<td><form:input path="type" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Color:</td>
				<td><form:input path="color" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Save</button>
				</td>
			</tr>
		</table>

	</form:form>

</body>
</html>