/*
 * Copyright © 2016-2018 dujoy.cn
 */
export default angular.module('thingsboard.api.componentDescriptor', [])
    .factory('componentDescriptorService', ComponentDescriptorService).name;

/*@ngInject*/
function ComponentDescriptorService($http, $q) {

    var componentsByType = {};
    var componentsByClazz = {};
    var actionsByPlugin = {};

    var service = {
        getComponentDescriptorsByType: getComponentDescriptorsByType,
        getComponentDescriptorByClazz: getComponentDescriptorByClazz,
        getPluginActionsByPluginClazz: getPluginActionsByPluginClazz
    }

    return service;

    function getComponentDescriptorsByType(componentType) {
        var deferred = $q.defer();
        if (componentsByType[componentType]) {
            deferred.resolve(componentsByType[componentType]);
        } else {
            var url = '/api/components/' + componentType;
            $http.get(url, null).then(function success(response) {
                componentsByType[componentType] = response.data;
                for (var i = 0; i < componentsByType[componentType].length; i++) {
                    var component = componentsByType[componentType][i];
                    componentsByClazz[component.clazz] = component;
                }
                deferred.resolve(componentsByType[componentType]);
            }, function fail() {
                deferred.reject();
            });

        }
        return deferred.promise;
    }

    function getComponentDescriptorByClazz(componentDescriptorClazz) {
        var deferred = $q.defer();
        if (componentsByClazz[componentDescriptorClazz]) {
            deferred.resolve(componentsByClazz[componentDescriptorClazz]);
        } else {
            var url = '/api/component/' + componentDescriptorClazz;
            $http.get(url, null).then(function success(response) {
                componentsByClazz[componentDescriptorClazz] = response.data;
                deferred.resolve(componentsByClazz[componentDescriptorClazz]);
            }, function fail() {
                deferred.reject();
            });
        }
        return deferred.promise;
    }

    function getPluginActionsByPluginClazz(pluginClazz) {
        var deferred = $q.defer();
        if (actionsByPlugin[pluginClazz]) {
            deferred.resolve(actionsByPlugin[pluginClazz]);
        } else {
            var url = '/api/components/actions/' + pluginClazz;
            $http.get(url, null).then(function success(response) {
                actionsByPlugin[pluginClazz] = response.data;
                deferred.resolve(actionsByPlugin[pluginClazz]);
            }, function fail() {
                deferred.reject();
            });
        }
        return deferred.promise;
    }

}
