<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script>
	angular.module('configureRuleApp', []).controller(
			'configureRuleController', function($scope, $http, $window) {

				$scope.ruleID= "<%=session.getAttribute("ruleID")%>";
						$scope.ruleMasterObj;
						$scope.ruleMasterId = $scope.ruleID;
						//alert($scope.ruleID);
						if ($scope.ruleID != "null") {
							//alert("Modify");
							$http({
								method : "GET",
								url : "/rules/ruleDetails/" + $scope.ruleID
							}).success(function(response) {
								//alert(response);
								$scope.ruleMasterObj = response;
								//alert($scope.ruleMasterObj.ruleStatus);
								$scope.ruleMasterId = $scope.ruleMasterObj.id;
								$scope.ruleNames = $scope.ruleMasterObj.ruleName;
								$scope.ruleTypes = $scope.ruleMasterObj.ruleType;
								$scope.rulePoints = $scope.ruleMasterObj.rulePoints;
								$scope.ruleDesc = $scope.ruleMasterObj.ruleDesc;
								$scope.rulePriorities = $scope.ruleMasterObj.rulePriority;
								$scope.ruleStatus = $scope.ruleMasterObj.ruleStatus;

							}).error(function(err) {
								alert("err indicative");
							});
						} else {
							//alert("New");
						}

						$http({
							method : "GET",
							url : "/rules/allRuleDetails",
							params : {
								colName : "ruleName"
							}
						}).success(function(response) {
							$scope.ruleNamesArr = response;
						}).error(function(err) {
							alert("err indicative");
						});

						$http({
							method : "GET",
							url : "/rules/allRuleDetails",
							params : {
								colName : "ruleType"
							}
						}).success(function(response) {
							$scope.ruleTypesArr = response;
						}).error(function(err) {
							alert("err indicative");
						});

						$scope.rulePrioritiesArr = [ "Blocker", "Critical","High", "Medium" ];

						$scope.ruleStatusArr = [ "Active", "In-Active" ];

						$scope.addRule = function() {
							var ruleNameVal, ruleTypeVal, rulePriorityVal, rulePointsVal, ruleStatusVal, ruleDesc;
							var url;

							ruleIdVal = $scope.ruleMasterId;
							//alert(ruleIdVal);
							rulePointsVal = $scope.rulePoints;
							ruleDesc = $scope.ruleDesc;
							rulePriorityVal = $scope.rulePriorities;
							ruleStatusVal = $scope.ruleStatus;

							if ($scope.ruleNames == "Other") {
								ruleNameVal = document
										.getElementById("ruleNameOther").value;
							} else {
								ruleNameVal = $scope.ruleNames;
							}

							if ($scope.ruleTypes == "Other") {
								ruleTypeVal = document
										.getElementById("ruleTypeOther").value;
							} else {
								ruleTypeVal = $scope.ruleTypes;
							}

							if (ruleIdVal == "null") {
								url = "addRule";
							} else {
								url = "updateRule";
							}
							$http({
								method : "GET",
								url : url,
								params : {
									ruleId : ruleIdVal,
									ruleName : ruleNameVal,
									ruleType : ruleTypeVal,
									rulePriority : rulePriorityVal,
									rulePoints : rulePointsVal,
									ruleStatus : ruleStatusVal,
									ruleDesc : ruleDesc
								}
							}).success(function(response) {
								$window.location.href = '/rules/rulesSummary';
							}).error(function(err) {
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
		configure the existing rules.</p>

	<div class="w3-container w3-half w3-margin-top">
		<form class="w3-container w3-card-4">

			<div ng-app="configureRuleApp"
				ng-controller="configureRuleController">
				<input type="hidden" ng-model="ruleMasterId" value="new">
				<table>
					<tr>
						<td>Rule Name:</td>
						<td><select ng-model="ruleNames"
							ng-options="option for option in ruleNamesArr">
								<option value="">-- Select Rule--</option>
						</select> <input ng-if="ruleNames == 'Other'" type="text"
							ng-model="ruleNameOther" id="ruleNameOther" value=""></td>
					</tr>
					<tr>
						<td>Rule Type:</td>
						<td><select ng-model="ruleTypes"
							ng-options="option for option in ruleTypesArr">
								<option value="">-- Select Type--</option>
						</select> <input ng-if="ruleTypes == 'Other'" type="text"
							ng-model="ruleTypeOther" id="ruleTypeOther"></td>
					</tr>
					<tr>
						<td>Rule Priority:</td>
						<td><select ng-model="rulePriorities"
							ng-options="option for option in rulePrioritiesArr">
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
							ng-options="option for option in ruleStatusArr">
								<option value="">-- Select Status--</option>
						</select></td>
					</tr>
					<tr>
						<td>Rule Description:</td>
						<td><textarea rows="4" cols="20" ng-model="ruleDesc"></textarea>
						</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<button class="w3-button w3-section w3-teal w3-ripple"
								ng-click="addRule()">Configure</button> &nbsp;&nbsp;
							<button class="w3-button w3-section w3-teal w3-ripple">Clear</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>