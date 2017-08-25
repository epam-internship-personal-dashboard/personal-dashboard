(function (app) {
    'use strict';

    var cmpt = {
        templateUrl: '/views/button.view.html',
        controllerAs: 'ctrl',
        bindings: {
            btnText: '@'
        }
    };

    app.component('pdButton', cmpt);

}(angular.module('pd.app')));
