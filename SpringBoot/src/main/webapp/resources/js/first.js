/**
 * 
 */

angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('students').
        then(function(response) {
            $scope.students = response.data;
        });
});


