(function (app) {
    'use strict';

    var cmpt = {
        templateUrl: '/views/header.view.html',
        controllerAs: 'ctrl'
    };

    app.component('pdHeader', cmpt);

}(angular.module('pd.app')));
