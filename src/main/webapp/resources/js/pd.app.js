(function () {
    'use strict';

    angular.module('pd.services', []);
    
    var modules = ['pd.views', 'pd.services', 'ngRoute'];
    angular.module('pd.app', modules);
}());
