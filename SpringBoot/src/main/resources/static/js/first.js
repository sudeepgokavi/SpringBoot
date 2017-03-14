/**
 * 
 */

angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:9191/students').
        then(function(response) {
            $scope.students = response.data;
        });
});