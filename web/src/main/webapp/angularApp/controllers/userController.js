'use strict';

angular.module('myApp')
    .controller('userController', function($scope, $http){
        $http.get('/web/user').success(function(users){
            console.log(users);
            $scope.users = users;
        });

        $scope.delete = function(id){
            $http({
                method:'DELETE',
                url:'web/user',
                params:{'id':id}
            }).success(function(){
                $route.reload();
            });
        };

        $http.delete('').success(function(){

        });

    });
