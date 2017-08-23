(function (app) {
    'use strict';

    var cmpt = {
        templateUrl: '/views/login.view.html',
        controllerAs: 'ctrl',
        controller: function($location){
        	var ctrl = this;
        	ctrl.$onInit = function (){
        		var searchObj = $location.search();
        		ctrl.msg = searchObj.hasOwnProperty("error");
        	};
        }
    };

    app.component('pdLogin', cmpt);

}(angular.module('pd.app')));
