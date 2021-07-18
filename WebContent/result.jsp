<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Display Page</h3>
<form action="display.do" method="post">
<input type="submit" value="showResult"/>

<ul>
		<c:forEach items="${list}" var="product">
			<li>${product.name} ${product.age} ${product.mobNum} ${product.email}  ${product.adress} ${product.result} ${product.state}</li>
		 </c:forEach>

		</ul>
</form>
</body>
</html>
	
