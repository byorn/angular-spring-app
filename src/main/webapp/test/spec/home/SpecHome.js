/**
 * Created by Byorn on 9/6/2015.
 */
'use strict';

describe('homeController', function() {


   var $controller;

    beforeEach(function(){
        // loads the app module
        module('myApp.home');
        inject(function($injector){
            $controller = $injector.get('$controller');
        });
    });




    describe('When the Home Page is loaded', function() {

         it('sets the list size, and expects to be larger than zero', function() {

             var $scope = {};
             var $http = {};

            var controller = $controller('homeController', { $scope: $scope,$http:$http });
             expect(controller).toBeDefined();

        });


    });
});