angular.module('myApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/user', {
                templateUrl: '/web/angularApp/views/user.html',
                controller: 'userController'
            })
            .when('/schema', {
                templateUrl: '/web/angularApp/views/schema.html',
                controller: 'schemaController'
            })
            .otherwise({
                redirectTo: '/'
            })

    });
