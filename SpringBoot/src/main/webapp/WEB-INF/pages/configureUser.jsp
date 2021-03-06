<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script>
angular.module('configUser', []).controller(
		'configUserController', function($scope, $http, $window, $filter) {

	$scope.userStatusArr = [ "Active", "Suspended" ];
	$scope.userRoleArr = [ "Admin", "Team Lead", "User" , "Approver" ];
	$scope.userCountryArr = [ "India", "United States" , "United Kingdom" ];
	
	$scope.userId= "<%=session.getAttribute("userId")%>
	";
						//alert($scope.userId);
						$scope.userMasterId = $scope.userId;

						if ($scope.userMasterId != "null") {
							//alert("Modify");
							$http({
								method : "GET",
								url : "/users/details/" + $scope.userId
							})
									.success(
											function(response) {
												//alert(response);
												$scope.userMasterObj = response;

												$scope.userName = $scope.userMasterObj.userName;
												$scope.userNickName = $scope.userMasterObj.userNickName;
												$scope.userPassword = $scope.userMasterObj.userPassword;
												$scope.userEmail = $scope.userMasterObj.userEmail;
												$scope.userMobile = $scope.userMasterObj.userMobile;
												$scope.userDOB = $filter('date')
														(
																$scope.userMasterObj.userDOB,
																'dd-MMM-yyyy');
												$scope.userCountry = $scope.userMasterObj.userCountry;
												$scope.userRole = $scope.userMasterObj.userRole;
												$scope.userJoiningDate = $filter(
														'date')
														(
																$scope.userMasterObj.userJoiningDate,
																'dd-MMM-yyyy');
												$scope.userStatus = $scope.userMasterObj.userStatus;
												$scope.userMasterId = $scope.userMasterObj.id;
											}).error(function(err) {
										alert("err indicative");
									});

						}

						$scope.addUser = function() {
							var url, method;

							if ($scope.userMasterId == "null") {
								url = "addUser";
								method = "GET";
							} else {
								url = "updateUser";
								method = "GET";
							}

							//alert(url + " -- "+method);
							$http({
								method : method,
								url : url,
								params : {
									userMasterId : $scope.userMasterId,
									userName : $scope.userName,
									userNickName : $scope.userNickName,
									userPassword : $scope.userPassword,
									userEmail : $scope.userEmail,
									userMobile : $scope.userMobile,
									//userDOB : $scope.userDOB,
									userDOB : "12-Nov-1988",
									userCountry : $scope.userCountry,
									userRole : $scope.userRole,
									//userJoiningDate : $scope.userJoiningDate,
									userJoiningDate : "12-Nov-1988",
									userStatus : $scope.userStatus
								}
							}).success(function(response) {
								//alert("ddddd");
								$window.location.href = '/users/userSummary';
							}).error(function(err) {
								alert("Error");
							});
						};

					});
</script>

<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

	<h2>User Management</h2>
	<p>This page will provide the functionality to add new Users and
		configure the existing Users.</p>
	<div class="w3-container w3-half w3-margin-top">
		<form class="w3-container w3-card-4">
			<div ng-app="configUser" ng-controller="configUserController"
				class="w3-container">
				<input type="hidden" ng-model="userMasterId" value="null">
				<table>
					<tr>
						<td>User Name:</td>
						<td><input type="text" ng-model="userName"></td>
					</tr>
					<tr>
						<td>User Nick Name:</td>
						<td><input type="text" ng-model="userNickName"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" ng-model="userPassword"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" ng-model="userEmail"></td>
					</tr>
					<tr>
						<td>Mobile:</td>
						<td><input type="text" ng-model="userMobile"></td>
					</tr>
					<tr>
						<td>DOB:</td>
						<td><input type="text" ng-model="userDOB"> &nbsp;<i>
								<small>(DD-MMM-YYYY)</small>
						</i></td>
					</tr>
					<tr>
						<td>User Country:</td>
						<td><select ng-model="userCountry"
							ng-options="option for option in userCountryArr">
								<option value="">-- Select Country--</option>
						</select></td>

					</tr>
					<tr>
						<td>User Role:</td>
						<td><select ng-model="userRole"
							ng-options="option for option in userRoleArr">
								<option value="">-- Select Role--</option>
						</select></td>
					</tr>
					<tr>
						<td>Use Joining Date:</td>
						<td><input type="text" ng-model="userJoiningDate">
							&nbsp;<i> <small>(DD-MMM-YYYY)</small></i></td>
					</tr>
					<tr>
						<td>User Status:</td>
						<td><select ng-model="userStatus"
							ng-options="option for option in userStatusArr">
								<option value="">-- Select Status--</option>
						</select></td>
					</tr>

					<tr align="center">
						<td colspan="2">
							<button class="w3-button w3-section w3-teal w3-ripple"
								ng-click="addUser()">Configure</button> &nbsp;&nbsp;
							<button class="w3-button w3-section w3-teal w3-ripple" u>Clear</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>