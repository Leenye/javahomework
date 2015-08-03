'use strict';

angular.module('myApp')
    .controller('schemaController', function($scope, $http){

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


        $scope.update = [];

        $scope.addSchema = function(){
            console.log($scope.selectedCourse+"----------------");
            console.log($scope.selectedCoach+"----------------");
            var time = $scope.time;
            //time = new Date(time).toLocaleDateString();

            console.log(time+"+++++++++++++++++++");
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
                $scope.schemas.push(schema);

            }).error(function () {
                alert(" 操作有误，请正确输入");
            });

            //$http.post('/web/angular/schema/',{params:{'course_id':$scope.selectedCourse,'coach_id':$scope.selectedCoach,'time':$scope.time,'customer':$scope.customer}}).success(function(schema){
            //    $scope.schemas.push(schema);
            //}).error(function(){
            //    alert("添加失败，请重试。");
            //});
        };



    });
