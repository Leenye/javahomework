'use strict';

angular.module('myApp')
    .controller('userController', function($scope, $http){

        $http.get('/web/angular/user/').success(function(users){
            $scope.users = users;
        });

        $scope.deleteUser = function(event,id){
            var tr = $(event.target).parent().parent();

            if(confirm("确定要删除该信息吗？")){
                $http({
                    method:'DELETE',
                    url:'/web/angular/user/',
                    params:{'id':id}
                }).success(function(){
                    tr.remove();
                    alert("删除成功");
                }).error(function(){
                    alert("删除失败，请重试") ;
                });
            }
        };

        $scope.addUser=function(){

            if($scope.name == null ||$scope.password == null || $scope.employee == null ){
                alert("请输入完整注册信息");
            }else{

                $http({
                    method:'POST',
                    url:'/web/angular/user/',
                    params:{
                        'name':$scope.name,
                        'password':$scope.password,
                        'employee_id':$scope.employee
                    }
                }).success(function(result){
                        if(result === "failed"){
                            alert("该工号已占用，请输入正确工号");
                        }else{
                            $scope.users.push(result);
                        }
                }
                ).error(function () {
                    alert(" 操作有误，请正确输入");
                });
            }
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

        $scope.cancelUpdate = function($index){
            $scope.update[$index] = true;
            $http({
                method:'GET',
                url:'/web/angular/user/'
            }).success(function(users){
                $scope.users = users;

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
