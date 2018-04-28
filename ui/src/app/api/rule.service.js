/*
 *
 */
export default angular.module('thingsboard.api.rule', [])
    .factory('ruleService', RuleService).name;

/*@ngInject*/
function RuleService($http, $q, $rootScope, $filter, types, utils) {

    var allRules = undefined;
    var systemRules = undefined;
    var tenantRules = undefined;

    $rootScope.ruleServiceStateChangeStartHandle = $rootScope.$on('$stateChangeStart', function () {
        invalidateRulesCache();
    });

    var service = {
        getSystemRules: getSystemRules,
        getTenantRules: getTenantRules,
        getAllRules: getAllRules,
        getRulesByPluginToken: getRulesByPluginToken,
        getRule: getRule,
        deleteRule: deleteRule,
        saveRule: saveRule,
        activateRule: activateRule,
        suspendRule: suspendRule
    }

    return service;

    function invalidateRulesCache() {
        allRules = undefined;
        systemRules = undefined;
        tenantRules = undefined;
    }

    function loadRulesCache(config) {
        var deferred = $q.defer();
        if (!allRules) {
            var url = '/api/rules';
            $http.get(url, config).then(function success(response) {
                allRules = response.data;
                systemRules = [];
                tenantRules = [];
                allRules = $filter('orderBy')(allRules, ['+name', '-createdTime']);
                for (var i = 0; i < allRules.length; i++) {
                    var rule = allRules[i];
                    if (rule.tenantId.id === types.id.nullUid) {
                        systemRules.push(rule);
                    } else {
                        tenantRules.push(rule);
                    }
                }
                deferred.resolve();
            }, function fail() {
                deferred.reject();
            });
        } else {
            deferred.resolve();
        }
        return deferred.promise;
    }

    function getSystemRules(pageLink) {
        var deferred = $q.defer();
        loadRulesCache().then(
            function success() {
                utils.filterSearchTextEntities(systemRules, 'name', pageLink, deferred);
            },
            function fail() {
                deferred.reject();
            }
        );
        return deferred.promise;
    }

    function getTenantRules(pageLink) {
        var deferred = $q.defer();
        loadRulesCache().then(
            function success() {
                utils.filterSearchTextEntities(tenantRules, 'name', pageLink, deferred);
            },
            function fail() {
                deferred.reject();
            }
        );
        return deferred.promise;
    }

    function getAllRules(pageLink, config) {
        var deferred = $q.defer();
        loadRulesCache(config).then(
            function success() {
                utils.filterSearchTextEntities(allRules, 'name', pageLink, deferred);
            },
            function fail() {
                deferred.reject();
            }
        );
        return deferred.promise;
    }

    function getRulesByPluginToken(pluginToken) {
        var deferred = $q.defer();
        var url = '/api/rule/token/' + pluginToken;
        $http.get(url, null).then(function success(response) {
            deferred.resolve(response.data);
        }, function fail() {
            deferred.reject();
        });
        return deferred.promise;
    }

    function getRule(ruleId, config) {
        var deferred = $q.defer();
        var url = '/api/rule/' + ruleId;
        $http.get(url, config).then(function success(response) {
            deferred.resolve(response.data);
        }, function fail(response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }

    function saveRule(rule) {
        var deferred = $q.defer();
        var url = '/api/rule';
        $http.post(url, rule).then(function success(response) {
            invalidateRulesCache();
            deferred.resolve(response.data);
        }, function fail(response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }

    function deleteRule(ruleId) {
        var deferred = $q.defer();
        var url = '/api/rule/' + ruleId;
        $http.delete(url).then(function success() {
            invalidateRulesCache();
            deferred.resolve();
        }, function fail(response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }

    function activateRule(ruleId) {
        var deferred = $q.defer();
        var url = '/api/rule/' + ruleId + '/activate';
        $http.post(url, null).then(function success(response) {
            invalidateRulesCache();
            deferred.resolve(response.data);
        }, function fail(response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }

    function suspendRule(ruleId) {
        var deferred = $q.defer();
        var url = '/api/rule/' + ruleId + '/suspend';
        $http.post(url, null).then(function success(response) {
            invalidateRulesCache();
            deferred.resolve(response.data);
        }, function fail(response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }

}
