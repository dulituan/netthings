/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import entityTypeListTemplate from './entity-type-list.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

import './entity-type-list.scss';

/*@ngInject*/
export default function EntityTypeListDirective($compile, $templateCache, $q, $mdUtil, $translate, $filter, types, entityService) {

    var linker = function (scope, element, attrs, ngModelCtrl) {

        var template = $templateCache.get(entityTypeListTemplate);
        element.html(template);

        scope.ngModelCtrl = ngModelCtrl;

        scope.placeholder = scope.tbRequired ? $translate.instant('entity.enter-entity-type')
                                : $translate.instant('entity.any-entity');
        scope.secondaryPlaceholder = '+' + $translate.instant('entity.entity-type');

        var entityTypes = entityService.prepareAllowedEntityTypesList(scope.allowedEntityTypes);
        scope.entityTypesList = [];
        for (var type in entityTypes) {
            var entityTypeInfo = {};
            entityTypeInfo.value = entityTypes[type];
            entityTypeInfo.name = $translate.instant(types.entityTypeTranslations[entityTypeInfo.value].type) + '';
            scope.entityTypesList.push(entityTypeInfo);
        }

        scope.$watch('tbRequired', function () {
            scope.updateValidity();
        });

        scope.fetchEntityTypes = function(searchText) {
            var deferred = $q.defer();
            var entityTypes = $filter('filter')(scope.entityTypesList, {name: searchText});
            deferred.resolve(entityTypes);
            return deferred.promise;
        }

        scope.updateValidity = function() {
            var value = ngModelCtrl.$viewValue;
            var valid = !scope.tbRequired || value && value.length > 0;
            ngModelCtrl.$setValidity('entityTypeList', valid);
        }

        ngModelCtrl.$render = function () {
            scope.entityTypeList = [];
            var value = ngModelCtrl.$viewValue;
            if (value && value.length) {
                value.forEach(function(type) {
                    var entityTypeInfo = {};
                    entityTypeInfo.value = type;
                    entityTypeInfo.name = $translate.instant(types.entityTypeTranslations[entityTypeInfo.value].type) + '';
                    scope.entityTypeList.push(entityTypeInfo);
                });
            }
        }

        scope.$watch('entityTypeList', function () {
            var values = [];
            if (scope.entityTypeList && scope.entityTypeList.length) {
                scope.entityTypeList.forEach(function(entityType) {
                    values.push(entityType.value);
                });
            }
            ngModelCtrl.$setViewValue(values);
            scope.updateValidity();
        }, true);

        $compile(element.contents())(scope);

        $mdUtil.nextTick(function(){
            var inputElement = angular.element('input', element);
            inputElement.on('blur', function() {
                scope.inputTouched = true;
            } );
        });

    }

    return {
        restrict: "E",
        require: "^ngModel",
        link: linker,
        scope: {
            disabled:'=ngDisabled',
            tbRequired: '=?',
            allowedEntityTypes: '=?'
        }
    };

}
