angular.module('user_management', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('')
            .when('/user', {
                templateUrl: '#/views/user.html',
                controller: 'userController'
            })
            .otherwise({
                redirectTo: '/111111'
            })

    });
