<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sample Project</title>
</head>
<body>
<p> <strong>People who have registered:</strong></p>
<c:forEach items = "${list}" var = "person">
	<p> ${person.toString()}</p>
</c:forEach>
</body>
</html>