(function (app) {
    'use strict';

    var component = {
        templateUrl: '/views/register.view.html',
        controllerAs: 'ctrl',
        controller: function (pdUserService, $location) {
            var ctrl = this;

            var successCallback = function(){
                ctrl.msg = false;
                $location.url('');
            };
            var errorCallback = function(){
                ctrl.msg = true;
            };

            ctrl.user = {
                role: 'ROLE_USER',
                enabled: 1
            };

            ctrl.submit = function () {
                pdUserService.save(ctrl.user, successCallback, errorCallback);
            };

        }
    };

    app.component('pdRegister', component);

}(angular.module('pd.app')));
