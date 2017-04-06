<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/first.js" />"></script>

<script type="text/javascript">

angular.module('rulesSummary', [])
.controller('rulesSummaryCtr', function($scope, $http) {
    $http.get('/rules/all').
        then(function(response) {
            $scope.listRulesObj = response.data;
        });
});
</script>
<meta charset="ISO-8859-1"></meta>
<title>Insert title here</title>
</head>
<body ng-app="rulesSummary">
	<h1>Welcome</h1>
	<div ng-controller="rulesSummaryCtr">

		<table border="1">
			<th>ID</th>
			<th>Rule Name</th>
			<th>Rule Type</th>
			<th>Rule Priority</th>
			<th>Rule Points</th>
			<th>Rule Status</th>
			<th>Rule Description</th>
			<tr ng-repeat="x in listRulesObj">
				<td>{{ x.id }}</td>
				<td>{{ x.ruleName }}</td>
				<td>{{ x.ruleType}}</td>
				<td>{{ x.rulePriority}}</td>
				<td>{{ x.rulePoints}}</td>
				<td>{{ x.ruleStatus}}</td>
				<td>{{ x.ruleDesc}}</td>
			</tr>
		</table>
		</div>
</body>
</html>