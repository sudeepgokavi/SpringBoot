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

angular.module('competitionSummary', [])
.controller('competitionSummaryCtr', function($scope, $http, $window) {
    $http.get('/competition/all').
        then(function(response) {
        	$scope.listRulesObj = response.data;
        });
    
    
    $scope.configureRule = function (competitionId) {
    	//alert(competitionId);
		$http({
			method: "GET",
			url : "viewCompetitionDetails",
			params: {
				competitionId : competitionId
			}					
		}).success(function(response){
			$window.location.href = '/competition/configureCompetition';
		}).error(function(err){
			alert("err indicative");
		}); 
    };

    $scope.deleteRule= function (competitionId) {
		$http({
			method: "GET",
			url : "/competition/delete/"+competitionId
		}).success(function(response){
		    $http.get('/competition/all').
	        then(function(response) {
	            $scope.listRulesObj = response.data;
	        });
		}).error(function(err){
			alert("err indicative");
		}); 
    };

    $scope.addNewComp= function () {
		$window.location.href = '/competition/configureCompetition'; 
    };

});
</script>
<meta charset="ISO-8859-1"></meta>
<title>Insert title here</title>
</head>
<body ng-app="competitionSummary">
	<div ng-controller="competitionSummaryCtr">
<p>
Competition Summary Page
<br>
<button ng-click="addNewComp()">New Competition </button>
</p>


 
<table class="w3-table w3-striped">
			<th>ID</th>
			<th>Competition Name</th>
			<th>Competition Details</th>
			<th>Competition Rules</th>
			<th>Competition Status</th>
			<th>Competition Start Date</th>
			<th>Competition End Date</th>
			<th>Competition Points</th>
			<th>Competition Prize</th>
			<th>Competition Owner</th>
			<th>Action</th>
			<tr ng-repeat="x in listRulesObj">
				<td>{{ x.id }}</td>
				<td>{{ x.competitionName }}</td>
				<td>{{ x.competitionDetails}}</td>
				<td>{{ x.competitionRules}}</td>
				<td>{{ x.competitionStatus}}</td>
				<td>{{ x.competitionStartDate | date : 'dd-MMM-yyyy'}}</td>
				<td>{{ x.competitionEndDate | date : 'dd-MMM-yyyy'}}</td>
				<td>{{ x.competitionPoints}}</td>
				<td>{{ x.competitionPrize}}</td>
				<td>{{ x.competitionOwner}}</td>
				<td> <button  ng-click="configureRule(x.id)">Configure</button>
				<button  ng-click="deleteRule(x.id)">Delete</button></td>
			</tr>
		</table>
		</div>
</body>
</html>