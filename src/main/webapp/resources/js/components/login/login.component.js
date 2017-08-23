(function (app) {
    'use strict';

    var cmpt = {
        templateUrl: '/views/login.view.html',
        controllerAs: 'ctrl'
    };

    app.component('pdLogin', cmpt);

}(angular.module('pd.app')));
