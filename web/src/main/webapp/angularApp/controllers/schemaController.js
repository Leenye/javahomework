'use strict';

angular.module('myApp')
    .controller('schemaController', function($scope, $http, $filter){

        $http.get('/web/angular/schema/').success(function(schemas){
            $scope.schemas = schemas;
        });

        $http.get('/web/angular/schema/course/').success(function(courses){
            $scope.courses = courses;

        });

        $http.get('/web/angular/schema/coach/').success(function(coaches){
            $scope.coaches = coaches;
        });

        $scope.deleteSchema = function($index,id){
            if (confirm("确定删除该条信息？")){
                $http.delete('/web/angular/schema/',{params:{'id':id}}).success(function(){
                    $scope.schemas.splice($index,1);
                }).error(function(){
                    alert("删除失败，请重试。")
                });
            }
        };

        $scope.addSchema = function(){
            var time = $scope.time;
            //time = new Date(time).toLocaleDateString();
            time = $filter('date')(time, 'yyyy-MM-dd');
            $http({
                method: 'POST',
                url: '/web/angular/schema/',
                params: {
                    'course_id': $scope.selectedCourse,
                    'coach_id': $scope.selectedCoach,
                    'time': time,
                    'customer': $scope.customer
                }
            }).success(function (schema) {
                console.log("add success~~~~~~~~~~~");
                $scope.schemas.push(schema);

            }).error(function () {
                alert(" 操作有误，请正确输入");
            });
        };

        $scope.update = [];
        $scope.updateCourse = [];
        $scope.updateCoach = [];
        $scope.updateTime = [];
        $scope.updateCustomer= [];
        $scope.updateSchema = function($index){
            $scope.update[$index] = false;
        };

        $scope.confirmUpdate = function($index){
            $scope.update[$index] = true;

            console.log($scope.updateCourse[$index]);
            console.log($scope.updateCoach[$index]);

           var time = new Date($scope.updateTime[$index]).toLocaleDateString();


            $http({
                method:'PUT',
                url:'/web/angular/schema/',
                params:{
                    'course_id': $scope.updateCourse[$index],
                    'coach_id': $scope.updateCoach[$index],
                    'time': time,
                    'customer': $scope.updateCustomer[$index]
                }
            }).success(function(){

            });
        }
    });
