(function () {
    'use strict';

    angular.module('pd.services').service('pdUserService', function($http){

        this.getAll = function(successCallback, errorCallback) {
            $http.get('/api/users').then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.getUser = function(id, successCallback, errorCallback) {
            $http.get('/api/users/'+id).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.saveUser = function(user, successCallback, errorCallback) {
            var request = {
                method: 'POST',
                url: '/api/users',
                data: user
            };

            $http(request).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.deleteUser =  function(id, successCallback, errorCallback){
            $http.delete('/api/users/'+id).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.updateUser =  function(id, successCallback, errorCallback) {
            $http.put('/api/users/' + id).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

    });

}());
