angular.module('user_management')
    .controller('userController', function($scope, $http){
        $http.get('/user').success(function(users){
            $scope.users = users;
        });

    });
