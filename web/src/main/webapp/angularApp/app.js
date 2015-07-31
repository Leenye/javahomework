angular.module('myApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/user', {
                templateUrl: '/web/angularApp/views/user.html',
                controller: 'userController'
            })
            .otherwise({
                redirectTo: '/'
            })

    });
