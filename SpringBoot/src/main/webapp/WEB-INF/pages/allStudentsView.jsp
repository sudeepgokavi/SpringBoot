<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/first.js" />" ></script>

<meta charset="ISO-8859-1"></meta>
<title>Insert title here</title>
</head>
<body  ng-app="demo">
	<h1>Welcome</h1>
	<div ng-controller="Hello">
		<table border="1">
			<th>ID</th>
			<th>Student Name</th>
			<th> Course Name </th>
			<tr ng-repeat="x in students">
				<td>{{ x.id }}</td>
				<td>{{ x.name }}</td>
				<td>{{ x.course}}</td>
			</tr>
		</table>

	</div>

</body>
</html>