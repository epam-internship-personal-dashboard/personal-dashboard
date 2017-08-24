(function () {
    'use strict';
    var path = 'api/users';
    angular.module('pd.services').service('pdUserService', function($http){

        this.getAll = function(successCallback, errorCallback) {
            $http.get(path).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.getUser = function(id, successCallback, errorCallback) {
            $http.get(path+id).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.save = function(user, successCallback, errorCallback) {
            var request = {
                method: 'POST',
                url: path,
                data: user
            };

            $http(request).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.deleteUser =  function(id, successCallback, errorCallback){
            $http.delete(path+id).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

        this.updateUser =  function(id, user, successCallback, errorCallback) {
            $http.put(path + id, user).then(function(responseObj) {
                successCallback(responseObj.data);
            }, function(errorObj) {
                errorCallback(errorObj.data);
            });
        };

    });

}());
