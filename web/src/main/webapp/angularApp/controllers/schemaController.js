'use strict';

angular.module('myApp')
    .controller('schemaController', function($scope, $http){

        $http.get('/web/angular/schema/').success(function(schemas){
            $scope.schemas = schemas;
        });

        $http.get('/web/angular/schema/course/').success(function(courses){
            $scope.courses = courses;
            console.log(courses);

        });

        $http.get('/web/angular/schema/coach/').success(function(coaches){
            $scope.coaches = coaches;
            console.log(coaches);
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



    });
