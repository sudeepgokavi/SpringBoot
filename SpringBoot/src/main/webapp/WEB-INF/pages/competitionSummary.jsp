<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 2px solid bisque !important;
}

#contributorHeader, #rankHeader {
	cursor: pointer !important;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

<script type="text/javascript">
	angular.module('competitionSummary', []).controller('competitionSummaryCtr',function($scope, $http, $window) {
		$http.get('/competition/all').then(function(response) {
			$scope.listRulesObj = response.data;
		});

		$scope.viewDetails = function(competitionId) {
			//alert(competitionId);
			$http({
				method : "GET",
				url : "viewCompetitionDetails",
				params : {
					competitionId : competitionId
				}
			}).success(function(response) {
					$window.location.href = '/competition/viewCompetition';
			}).error(function(err) {
					alert("err indicative");
			});
		};
		
		$scope.configureRule = function(competitionId) {
			//alert(competitionId);
			$http({
				method : "GET",
				url : "viewCompetitionDetails",
				params : {
					competitionId : competitionId
				}
			}).success(function(response) {
					$window.location.href = '/competition/configureCompetition';
			}).error(function(err) {
					alert("err indicative");
			});
		};

		$scope.deleteRule = function(competitionId) {
			$http({
				method : "GET",
				url : "/competition/delete/" + competitionId
			}).success(function(response) {
				$http.get('/competition/all').then(function(response) {
					$scope.listRulesObj = response.data;
				});
			}).error(function(err) {
				alert("err indicative");
			});
		};

		$scope.addNewComp = function() {
			$window.location.href = '/competition/configureCompetition';
		};

	});
</script>
<meta charset="ISO-8859-1"></meta>
<title>Competition Summary Page</title>
</head>
<body ng-app="competitionSummary">
	<div ng-controller="competitionSummaryCtr">
		<h2>Competition Summary Page</h2>
		<p>
			Summary of all the competition registered. <br>
			<button class="w3-button w3-section w3-teal w3-ripple"
				ng-click="addNewComp()">New Competition</button>
		</p>

		<div class="w3-container">

			<table class="w3-table-all w3-card-4">
				<thead>
					<tr class="w3-teal">
						<th>ID</th>
						<th>Name</th>
						<th>Details</th>
						<th>Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Points</th>
						<th>Prize</th>
						<th>Owner</th>
						<th>Action</th>
					</tr>
				</thead>
				<tr ng-repeat="x in listRulesObj">
					<td>{{ x.id }}</td>
					<td><a href="#" ng-click="viewDetails(x.id)">{{ x.competitionName }}</a></td>
					<td>{{ x.competitionDetails}}</td>
					<td>{{ x.competitionStatus}}</td>
					<td>{{ x.competitionStartDate | date : 'dd-MMM-yyyy'}}</td>
					<td>{{ x.competitionEndDate | date : 'dd-MMM-yyyy'}}</td>
					<td>{{ x.competitionPoints}}</td>
					<td>{{ x.competitionPrize}}</td>
					<td>{{ x.competitionOwner}}</td>
					<td><a href="#" ng-click="configureRule(x.id)"><i class="fa fa-edit" style="font-size:24px;color:blue"></i></a>
						<a href="#" ng-click="deleteRule(x.id)"><i class="material-icons" style="font-size:24px;color:red">delete_forever</i> </a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>