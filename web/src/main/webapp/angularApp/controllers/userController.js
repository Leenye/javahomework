'use strict';

angular.module('myApp')
    .controller('userController', function($scope, $http){

        $http.get('/web/angular/user/').success(function(users){
            $scope.users = users;
        });

        $scope.deleteUser = function(event,id){
            var tr = $(event.target).parent().parent();
            $http({
                method:'DELETE',
                url:'/web/angular/user/',
                params:{'id':id}
            }).success(function(){
                tr.remove();
            });
        };

        $scope.addUser=function(){
            $http({
                method:'POST',
                url:'/web/angular/user/',
                params:{
                    'name':$scope.name,
                    'password':$scope.password,
                    'employee_id':$scope.employee
                }
            }).success(function(user){
                $scope.users.push(user);
            });
        };

        $scope.update = [];

        $scope.updateUser = function($index){
            $scope.update[$index] = false;
        };

        $scope.commitUpdate = function($index,user){
            $scope.update[$index] = true;

            $http({
                method:'PUT',
                url:'/web/angular/user/',
                params:{
                    'id':user.id,
                    'name':user.name,
                    'password':user.password,
                    'employee_id':user.employee.id
                }
            }).success(function(){

            });
        };

        //$scope.test= function () {
        //    console.log($scope.hello);
        //    $http({
        //        method: 'POST',
        //        url: '/web/angular/user',
        //        params: {"name":$scope.hello,
        //        "password":"123",
        //        "employee_id":8}
        //    }).success(function () {
        //        console.log("It's ok");
        //    });
        //};

        //    $http.post('/web/angular/test',{'name':name}).success(function() {
        //            console.log("It's ok")}
        //    );
        //}

    });
