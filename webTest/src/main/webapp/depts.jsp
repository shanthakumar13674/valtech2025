<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counters = ${counters}
Current Dept = ${current}
<form action="depts" method="post">
<table>
<tr>
	<td>Id</td>
	<td>${dept.id}</td>
</tr>
<tr>
	<td>Name</td>
	<td>${dept.name}</td>
</tr>
<tr>
	<td>Location</td>
	<td>${dept.location}</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit"  name="operation" value="First"/>
		<input type="submit"  name="operation" value="Previous"/>
		<input type="submit"  name="operation" value="Next"/>
		<input type="submit"  name="operation" value="Last"/>
	</td>
</tr>
</table>
</form>
</body>
</html>