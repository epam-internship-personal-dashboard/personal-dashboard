(function () {
    'use strict';

    angular.module('pd.app').config(function($routeProvider, $locationProvider){
        $routeProvider
        .when('/', {
            template: '<pd-login></pd-login>'
        })
        .when('/register', {
            template: '<pd-register></pd-register>'
        })
        .when('/userProfile', {
            template: '<pd-userProfile></pd-userProfile>'
        });
        $locationProvider.html5Mode(true);
    });
}());
