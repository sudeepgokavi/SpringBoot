<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
border: 2px solid bisque !important;
}

#contributorHeader, #rankHeader{
cursor : pointer !important;
}
</style>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/first.js" />"></script>

<script type="text/javascript">

angular.module('rulesSummary', [])
.controller('rulesSummaryCtr', function($scope, $http, $window) {
    $http.get('/rules/all').
        then(function(response) {
            $scope.listRulesObj = response.data;
        });
    
    $scope.configureRule = function (ruleID) {
		$http({
			method: "GET",
			url : "viewRuleDetails",
			params: {
				ruleID : ruleID
			}					
		}).success(function(response){
			$window.location.href = '/rules/configureRule';
		}).error(function(err){
			alert("err indicative");
		}); 
    };

    $scope.deleteRule= function (ruleID) {
		$http({
			method: "GET",
			url : "/rules/deleteRule/"+ruleID
		}).success(function(response){
		    $http.get('/rules/all').
	        then(function(response) {
	            $scope.listRulesObj = response.data;
	        });
		}).error(function(err){
			alert("err indicative");
		}); 
    };

});
</script>
<meta charset="ISO-8859-1"></meta>
<title>Insert title here</title>
</head>
<body ng-app="rulesSummary">
	<h1>Welcome</h1>
	<div ng-controller="rulesSummaryCtr">

<table class="w3-table w3-striped">
			<th>ID</th>
			<th>Rule Name</th>
			<th>Rule Type</th>
			<th>Rule Priority</th>
			<th>Rule Points</th>
			<th>Rule Status</th>
			<th>Rule Description</th>
			<th>Action</th>			
			<tr ng-repeat="x in listRulesObj">
				<td>{{ x.id }}</td>
				<td>{{ x.ruleName }}</td>
				<td>{{ x.ruleType}}</td>
				<td>{{ x.rulePriority}}</td>
				<td>{{ x.rulePoints}}</td>
				<td>{{ x.ruleStatus}}</td>
				<td>{{ x.ruleDesc}}</td>
				<td> <button  ng-click="configureRule(x.id)">Configure</button>
				<button  ng-click="deleteRule(x.id)">Delete</button></td>
			</tr>
		</table>
		</div>
</body>
</html>