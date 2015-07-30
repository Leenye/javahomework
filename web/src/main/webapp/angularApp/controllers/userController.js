'use strict';

angular.module('myApp')
    .controller('userController', function($scope, $http){
        $http.get('/web/user').success(function(users){
            $scope.users = users;
        });

        $scope.deleteUser = function(event,id){
            var tr = $(event.target).parent().parent();
            console.log($(event));
            //$event.target();
            $http({
                method:'DELETE',
                url:'/web/user/deleteUser',
                params:{'id':id}

            }).success(function(){
                tr.remove();

                //$route.reload();
            });
        };

    });
