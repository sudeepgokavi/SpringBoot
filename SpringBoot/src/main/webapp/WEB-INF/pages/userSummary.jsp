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
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/first.js" />"></script>

<script type="text/javascript">
	angular.module('userSummary', []).controller('userSummaryCtr',
			function($scope, $http, $window) {
				$http.get('/users/all').then(function(response) {
					$scope.listUserObj = response.data;
				});

				$scope.configureUser = function(userId) {
					//alert(competitionId);
					$http({
						method : "GET",
						url : "viewUserDetails",
						params : {
							userId : userId
						}
					}).success(function(response) {
						$window.location.href = '/users/configureUser';
					}).error(function(err) {
						alert("err indicative");
					});
				};

				$scope.deleteUser = function(userId) {
					$http({
						method : "GET",
						url : "/users/delete/" + userId
					}).success(function(response) {
						$http.get('/users/all').then(function(response) {
							$scope.listUserObj = response.data;
						});
					}).error(function(err) {
						alert("err indicative");
					});
				};

				$scope.addNewUser = function() {
					$window.location.href = '/users/configureUser';
				};

			});
</script>
<meta charset="ISO-8859-1"></meta>
<title>User Management</title>
</head>
<body ng-app="userSummary">
	<div ng-controller="userSummaryCtr">

		<h2>User Summary Page</h2>
		<p>
			This page will provide the list & details of all the Users. <br>
			<button ng-click="addNewUser()">New User</button>
		</p>



		<table class="w3-table w3-striped">
			<th>ID</th>
			<th>User Name</th>
			<th>User Nick Name</th>
			<th>User Email</th>
			<th>User Mobile</th>
			<th>User DOB</th>
			<th>User Country</th>
			<th>User Role</th>
			<th>User Status</th>
			<th>User Joining Date</th>
			<th>Action</th>
			<tr ng-repeat="x in listUserObj">
				<td>{{ x.id}}</td>
				<td>{{ x.userName }}</td>
				<td>{{ x.userNickName}}</td>
				<td>{{ x.userEmail}}</td>
				<td>{{ x.userMobile}}</td>
				<td>{{ x.userDOB | date : 'dd-MMM-yyyy'}}</td>
				<td>{{ x.userCountry}}</td>
				<td>{{ x.userRole}}</td>
				<td>{{ x.userStatus}}</td>
				<td>{{ x.userJoiningDate | date : 'dd-MMM-yyyy'}}</td>
				<td>
					<button ng-click="configureUser(x.id)">Configure</button>
					<button ng-click="deleteUser(x.id)">Delete</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>