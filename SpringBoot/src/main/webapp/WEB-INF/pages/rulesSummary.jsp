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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

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

	$scope.addNewRule = function() {
		$window.location.href = '/rules/configureRule';
	};

});
</script>
<meta charset="ISO-8859-1"></meta>
<title>Rules Summary</title>
</head>
<body ng-app="rulesSummary">
	<div ng-controller="rulesSummaryCtr">
		<div class="w3-container">
			<h2>Rules Summary Page</h2>
			<p>
				This page will provide the list & details of all the Rules. <br>
				<button class="w3-button w3-section w3-teal w3-ripple" ng-click="addNewRule()">New Rule</button>
			</p>
			<table class="w3-table-all w3-card-4">
				<thead>
					<tr class="w3-teal">
						<th>ID</th>
						<th>Rule Name</th>
						<th>Rule Type</th>
						<th>Rule Priority</th>
						<th>Rule Points</th>
						<th>Rule Status</th>
						<th>Rule Description</th>
						<th>Action</th>
					</tr>
				</thead>			
				<tr ng-repeat="x in listRulesObj">
					<td>{{ x.id }}</td>
					<td>{{ x.ruleName }}</td>
					<td>{{ x.ruleType}}</td>
					<td>{{ x.rulePriority}}</td>
					<td>{{ x.rulePoints}}</td>
					<td>{{ x.ruleStatus}}</td>
					<td>{{ x.ruleDesc}}</td>
					<td>
						<a href="#" ng-click="configureRule(x.id)"><i class="fa fa-edit" style="font-size:24px;color:blue"></i></a>
						<a href="#" ng-click="deleteRule(x.id)"><i class="material-icons" style="font-size:24px;color:red">delete_forever</i> </a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>