(function () {
    'use strict';

    angular.module('pd.services').service('pdUserService', function($http){
    	this.getAll = function(noErrorCallback, errorCallback){
    		$http.get('/api/users').then(function(responseObj){
    			noErrorCallback(responseObj.data);
    		}, 
    		function(errorObj) {
    			errorCallback(errorObj.data);
    		});
    	}
    	
    	this.getUser = function(id){
    		$http.get('/api/users/'+id).then(function(responseObj){
    			return responsObj.data;
    		},
    		function(errorObj) {
    			return errorObj.data;
    		});
    	}
    	
    	this.saveUser = function(user){
    		$http('').then(function(responseObj){
    			return responsObj.data;
    		},
    		function(errorObj) {
    			return errorObj.data;
    		});
    	}
    });

}());