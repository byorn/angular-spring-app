/**
 * Created by byorn on 3/24/15.
 */
'use strict';
angular.module('myApp.new_or_edit', ['ngRoute'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/new_or_edit', {
            templateUrl: 'new_or_edit/new_or_edit.html',
            controller: 'NewController'
        }).
        when('/new_or_edit/:id/:name', {
            templateUrl: 'new_or_edit/new_or_edit.html',
            controller: 'EditController'
        });
    }])
    .controller('EditController', function($scope,$routeParams,$http,$location) {

        $scope.id=$routeParams.id;
        $scope.name=$routeParams.name;

        $scope.submit = function() {
         
            var book = {
                       	id: $scope.id,
                        name:$scope.name
            };
            
            $http.post('/books', book,{}).
                    success(function(data, status, headers, config) {
                          $location.path( "/home" );
                    }).
                    error(function(data, status, headers, config) {
                          
                    });
                
        }
       
      
    })
    .controller('NewController', function($scope,$routeParams,$http,$location) {


        $scope.submit = function() {

            var book = {
                id: $scope.id,
                name: $scope.name
            };

            $http.post('/books/createNew', book,{}).
                success(function(data, status, headers, config) {
                    $location.path( "/home" );
                }).
                error(function(data, status, headers, config) {

                });

        }


    });

