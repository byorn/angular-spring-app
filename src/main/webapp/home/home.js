/**
 * Created by byorn on 3/24/15.
 */
'use strict';
angular.module('myApp.home', ['ngRoute'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/home', {
            templateUrl: 'home/home.html',
            controller: 'homeController'
        });
    }])
    .controller('homeController', function($scope, $http) {
        $http.get('/books')
            .then(function(res){
                $scope.books = res.data;
            });
        
        
    });

