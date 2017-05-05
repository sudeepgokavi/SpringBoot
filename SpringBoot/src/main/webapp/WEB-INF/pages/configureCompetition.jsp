<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

<script>
angular.module('configCompetition', []).controller(
		'configCompetitionController', function($scope, $http, $window, $filter) {

	$scope.competitionStatusArr = [ "Accepting Entries", "Suspended" , "Not Accepting Entries", "Closed" ];
	
	$scope.competitionId = "<%= session.getAttribute("competitionId")%>";
	$scope.competitionMasterObj;
	$scope.competitionMasterId =  $scope.competitionId;
	//alert($scope.competitionId);
	
	if($scope.competitionId != "null"){
		//alert("Modify");
		$http({
			method: "GET",
			url : "/competition/details/"+$scope.competitionId
		}).success(function(response){
			//alert(response);
			$scope.competitionMasterObj = response;

			$scope.competitionMasterId = $scope.competitionMasterObj.id;
			$scope.competitionDetails = $scope.competitionMasterObj.competitionDetails;
			$scope.competitionName = $scope.competitionMasterObj.competitionName;
			$scope.competitionOwner = $scope.competitionMasterObj.competitionOwner;
			$scope.competitionPoints = $scope.competitionMasterObj.competitionPoints;
			$scope.competitionPrize = $scope.competitionMasterObj.competitionPrize;
			$scope.competitionRules = $scope.competitionMasterObj.competitionRules;
			$scope.competitionStatus = $scope.competitionMasterObj.competitionStatus ;
			//$scope.competitionEndDate = $scope.competitionMasterObj.competitionEndDate;
			$scope.competitionEndDate = $filter('date')($scope.competitionMasterObj.competitionEndDate,'dd-MMM-yyyy');
			//$scope.competitionStartDate = $scope.competitionMasterObj.competitionStartDate;
			$scope.competitionStartDate = $filter('date')($scope.competitionMasterObj.competitionStartDate,'dd-MMM-yyyy');

		}).error(function(err){
			alert("err indicative");
		}); 
		
	}

    $scope.addRule = function () {
    	
    	var url;
    	//alert("--"+$scope.competitionMasterId+"--")
    	if($scope.competitionMasterId == "null" || $scope.competitionMasterId == "undefined"){
    		url = "add";
    	}else{
    		url = "update";
    	}
    	
		$http({
			method: "GET",
			url : url,
			params: {
				competitionMasterId : $scope.competitionMasterId,
				competitionDetails : $scope.competitionDetails,
				competitionName : $scope.competitionName,
				competitionOwner : $scope.competitionOwner,
				competitionPoints : $scope.competitionPoints,
				competitionPrize : $scope.competitionPrize,
				competitionRules : $scope.competitionRules,
				competitionStatus : $scope.competitionStatus,
				competitionEndDate : $scope.competitionEndDate,
				competitionStartDate : $scope.competitionStartDate
			}					
		}).success(function(response){
			$window.location.href = '/competition/competitionSummary';
		}).error(function(err){
			alert("err indicative");
		}); 
    };

});
</script>

<meta charset="ISO-8859-1">
<title>Competition Management</title>
</head>
<body>

	<h2>Competition Management</h2>
	<p>This page will provide the functionality to add new Competition
		and configure the existing Competition.
		</p>
		
	<div ng-app="configCompetition"
		ng-controller="configCompetitionController" class="w3-container">
		<input type="hidden" ng-model="competitionMasterId" value="null">
		<table>
			<tr>
				<td>Competition Name:</td>
				<td><input type="text" ng-model="competitionName" ></td>
			</tr>
			<tr>
				<td>Competition Details:</td>
				<td><textarea rows="3" cols="50" ng-model="competitionDetails"></textarea>
				</td>
			</tr>
			<tr>
				<td>Competition Rules:</td>
				<td><textarea rows="6" cols="50" ng-model="competitionRules"></textarea>
				</td>
			</tr>
			<tr>
				<td>Competition Start Date:</td>
				<td><input type="text" ng-model="competitionStartDate"> &nbsp;<i><small>(DD/MMM/YYYY)</small></i>
				</td>
			</tr>
			<tr>
				<td>Competition End Date:</td>
				<td><input type="text" ng-model="competitionEndDate">  &nbsp;<i> <small>(DD/MMM/YYYY)</small></i></td>
			</tr>
			<tr>
				<td>Competition Points:</td>
				<td><input type="text" ng-model="competitionPoints"></td>
			</tr>
			<tr>
				<td>Competition Prize:</td>
				<td><input type="text" ng-model="competitionPrize"></td>
			</tr>
			<tr>
				<td>Competition Owned By:</td>
				<td><input type="text" ng-model="competitionOwner"></td>
			</tr>
			<tr>
				<td>Competition Status:</td>
				<td><select ng-model="competitionStatus"
					ng-options="option for option in competitionStatusArr">
						<option value="">-- Select Status--</option>
				</select></td>
			</tr>

			<tr align="center">
				<td colspan="2">
					<button  ng-click="addRule()">Configure</button> &nbsp;&nbsp;
					<button>Clear</button>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>