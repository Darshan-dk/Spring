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
<form action="add.do" method="post">
<pre>
		Name:<input type="text" name="name">
		 age:<input type="text" name="age" value="0"> 
			MobNum:<input type="text" name="mobNum" value="0"> 
			Email:<input type="text" name="email"> 
			address:<input type="text" name="adress"> 
			result yes:<input type="checkbox" value="yes" name="result"> 
					no:<input type="checkbox" value="no" name="result">
			State:<select name="state">
			<option>select</option>
			<c:forEach items="${states}" var="s">
			<option>${s}</option>
			</c:forEach>
			</select>
			<input type="submit" value="SAVE" name="submit">

</pre>
</form>

	<form action="result.jsp">
		<input type="submit" value="display" name="submit"/>
	</form> 



</body>
</html>
	