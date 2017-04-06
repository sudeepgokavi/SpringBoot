<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

<script>
	angular.module('configureRuleApp', []).controller(
			'configureRuleController', function($scope, $http, $window) {

				$scope.ruleNamesArr = [ {
					ruleName : "Sonar"
				}, {
					ruleName : "Defect"
				}, {
					ruleName : "Issue"
				}, {
					ruleName : "Other"
				}, ];

				$scope.ruleTypesArr = [ {
					ruleType : "Voilation"
				}, {
					ruleType : "Fix"
				}, {
					ruleType : "Code Fix"
				}, {
					ruleType : "Other"
				}, ];

				$scope.rulePrioritiesArr = [ {
					rulePriority : "Blocker"
				}, {
					rulePriority : "Critical"
				}, {
					rulePriority : "High"
				}, {
					rulePriority : "Medium"
				}, ];

				$scope.ruleStatusArr = [ {
					ruleStatus : "Active"
				}, {
					ruleStatus : "In-Active"
				}, ];
				
				
	            $scope.addRule = function () {
	            	var ruleNameVal, ruleTypeVal, rulePriorityVal, rulePointsVal, ruleStatusVal, ruleDesc;
	            	
	            	rulePointsVal = $scope.rulePoints;
	            	ruleDesc = $scope.ruleDesc;
	            	rulePriorityVal = $scope.rulePriorities.rulePriority;
	            	ruleStatusVal = $scope.ruleStatus.ruleStatus;
	            	
	            	if($scope.ruleNames.ruleName == "Other"){
	            		ruleNameVal = document.getElementById("ruleNameOther").value;
	            	}else{
	            		ruleNameVal = $scope.ruleNames.ruleName;
	            	}
	            	
	            	if($scope.ruleTypes.ruleType == "Other"){
	            		ruleTypeVal = document.getElementById("ruleTypeOther").value;
	            	}else{
	            		ruleTypeVal = $scope.ruleTypes.ruleType;
	            	}
	            	
					$http({
						method: "GET",
						url : "addRule",
						params: {
							ruleName : ruleNameVal,
							ruleType : ruleTypeVal,
							rulePriority : rulePriorityVal,
							rulePoints : rulePointsVal,
							ruleStatus : ruleStatusVal,
							ruleDesc : ruleDesc
						}					
					}).success(function(response){
						$window.location.href = '/rules/rulesSummary';
					}).error(function(err){
						alert("err indicative");
					}); 

	            };

			});
</script>

<meta charset="ISO-8859-1">
<title>Configure Rules</title>
</head>
<body>

	<h2>Configure Rules</h2>
	<p>This page will provide the functionality to add new rules and
		configure the existing rules.
	<div ng-app="configureRuleApp" ng-controller="configureRuleController"
		class="w3-container">
		<table>
			<tr>
				<td>Rule Name:</td>
				<td><select ng-model="ruleNames"
					ng-options="option.ruleName for option in ruleNamesArr">
						<option value="">-- Select Rule--</option>
				</select> <input ng-if="ruleNames.ruleName == 'Other'" type="text"
					ng-model="ruleNameOther" id="ruleNameOther" value=""></td>
			</tr>
			<tr>
				<td>Rule Type:</td>
				<td><select ng-model="ruleTypes"
					ng-options="option.ruleType for option in ruleTypesArr">
						<option value="">-- Select Type--</option>
				</select> <input ng-if="ruleTypes.ruleType == 'Other'" type="text"
					ng-model="ruleTypeOther" id="ruleTypeOther"></td>
			</tr>
			<tr>
				<td>Rule Priority:</td>
				<td><select ng-model="rulePriorities"
					ng-options="option.rulePriority for option in rulePrioritiesArr">
						<option value="">-- Select Priority--</option>
				</select></td>

			</tr>
			<tr>
				<td>Rule Points:</td>
				<td><input type="text" ng-model="rulePoints" size="10">
				</td>
			</tr>
			<tr>
				<td>Rule Status:</td>
				<td><select ng-model="ruleStatus"
					ng-options="option.ruleStatus for option in ruleStatusArr">
						<option value="">-- Select Status--</option>
				</select></td>
			</tr>
			<tr>
				<td>Rule Description:</td>
				<td><textarea rows="4" cols="20" ng-model="ruleDesc"></textarea>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"> <button ng-click="addRule()"> Add </button> &nbsp;&nbsp; <button> Clear </button></td>
			</tr>
		</table>
	</div>
	
</body>
</html>