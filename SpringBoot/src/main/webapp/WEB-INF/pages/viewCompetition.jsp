<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script>
angular.module('viewCompetition', []).controller(
		'viewCompetitionController', function($scope, $http, $window, $filter) {

	$scope.competitionStatusArr = [ "Accepting Entries", "Suspended" , "Not Accepting Entries", "Closed" ];
	
	$scope.competitionId = "<%=session.getAttribute("competitionId")%>";
	$scope.competitionMasterObj;
	$scope.competitionMasterId = $scope.competitionId;
	//alert($scope.competitionId);

	if ($scope.competitionId != "null") {
		//alert("Modify");
		$http({
			method : "GET",
			url : "/competition/details/"+ $scope.competitionId
		}).success(function(response) {
			//alert(response.competitionName);
			$scope.competitionMasterObj = response;

		}).error(function(err) {
			alert("err indicative");
		});
	}

});
</script>

<meta charset="ISO-8859-1">
<title>Competition Management</title>
</head>
<body>

	<h2>View Competition Details</h2>
	<p>
		Detailed view of the Competition.<br>
		<a href="competitionSummary"> Competition Summary</a>
	</p>
	<div class="w3-container w3-full w3-margin-top">
		<form class="w3-container w3-card-4">

			<div ng-app="viewCompetition"
				ng-controller="viewCompetitionController" class="w3-container">
				<input type="hidden" ng-model="competitionMasterId" value="null">
				<table>
					<tr>
						<td>Name:</td>
						<td>{{competitionMasterObj.competitionName}}</td>
					</tr>
					<tr>
						<td>Details:</td>
						<td>{{competitionMasterObj.competitionDetails}}</td>
					</tr>
					<tr>
						<td>Rules:</td>
						<td>{{competitionMasterObj.competitionRules}}</td>
					</tr>
					<tr>
						<td>Start Date:</td>
						<td>{{competitionMasterObj.competitionStartDate | date : 'dd-MMM-yyyy'}}</td>
					</tr>
					<tr>
						<td>End Date:</td>
						<td>{{competitionMasterObj.competitionEndDate | date : 'dd-MMM-yyyy'}}</td>
					</tr>
					<tr>
						<td>Points:</td>
						<td>{{competitionMasterObj.competitionPoints}}</td>
					</tr>
					<tr>
						<td>Prize:</td>
						<td>{{competitionMasterObj.competitionPrize}}</td>
					</tr>
					<tr>
						<td>Owned By:</td>
						<td>{{competitionMasterObj.competitionOwner}}</td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td>{{competitionMasterObj.compContactPhone}}</td>
						
					</tr>
					<tr>
						<td>Email:</td>
						<td>{{competitionMasterObj.compContactEmail}}</td>
					</tr>
					<tr>
						<td>Status:</td>
						<td>{{competitionMasterObj.competitionStatus}}</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<button class="w3-button w3-section w3-teal w3-ripple">Register</button>
						</td>
					</tr>

				</table>
			</div>
		</form>
	</div>
</body>
</html>