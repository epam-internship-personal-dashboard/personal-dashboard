(function (app) {
    'use strict';

    var cmpt = {
        templateUrl: '/views/userProfile.view.html',
        controllerAs: 'ctrl'
    };

    app.component('pdUserProfile', cmpt);

}(angular.module('pd.app')));
