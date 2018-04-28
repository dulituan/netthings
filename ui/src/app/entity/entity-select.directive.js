/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './entity-select.scss';

/* eslint-disable import/no-unresolved, import/default */

import entitySelectTemplate from './entity-select.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function EntitySelect($compile, $templateCache) {

    var linker = function (scope, element, attrs, ngModelCtrl) {
        var template = $templateCache.get(entitySelectTemplate);
        element.html(template);

        scope.tbRequired = angular.isDefined(scope.tbRequired) ? scope.tbRequired : false;
        scope.model = {};

        scope.updateView = function () {
            if (!scope.disabled) {
                var value = ngModelCtrl.$viewValue;
                if (scope.model && scope.model.entityType && scope.model.entityId) {
                    if (!value) {
                        value = {};
                    }
                    value.entityType = scope.model.entityType;
                    value.id = scope.model.entityId;
                    ngModelCtrl.$setViewValue(value);
                } else {
                    ngModelCtrl.$setViewValue(null);
                }
            }
        }

        ngModelCtrl.$render = function () {
            destroyWatchers();
            if (ngModelCtrl.$viewValue) {
                var value = ngModelCtrl.$viewValue;
                scope.model.entityType = value.entityType;
                scope.model.entityId = value.id;
            } else {
                scope.model.entityType = null;
                scope.model.entityId = null;
            }
            initWatchers();
        }

        function initWatchers() {
            scope.entityTypeDeregistration = scope.$watch('model.entityType', function (newVal, prevVal) {
                if (!angular.equals(newVal, prevVal)) {
                    scope.updateView();
                }
            });

            scope.entityIdDeregistration = scope.$watch('model.entityId', function (newVal, prevVal) {
                if (!angular.equals(newVal, prevVal)) {
                    scope.updateView();
                }
            });

            scope.disabledDeregistration = scope.$watch('disabled', function (newVal, prevVal) {
                if (!angular.equals(newVal, prevVal)) {
                    scope.updateView();
                }
            });
        }

        function destroyWatchers() {
            if (scope.entityTypeDeregistration) {
                scope.entityTypeDeregistration();
                scope.entityTypeDeregistration = null;
            }
            if (scope.entityIdDeregistration) {
                scope.entityIdDeregistration();
                scope.entityIdDeregistration = null;
            }
            if (scope.disabledDeregistration) {
                scope.disabledDeregistration();
                scope.disabledDeregistration = null;
            }
        }

        $compile(element.contents())(scope);
    }

    return {
        restrict: "E",
        require: "^ngModel",
        link: linker,
        scope: {
            theForm: '=?',
            tbRequired: '=?',
            disabled:'=ngDisabled',
            useAliasEntityTypes: "=?"
        }
    };
}
