/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './widgets-bundle-select.scss';

import thingsboardApiWidget from '../api/widget.service';

/* eslint-disable import/no-unresolved, import/default */

import widgetsBundleSelectTemplate from './widgets-bundle-select.tpl.html';

/* eslint-enable import/no-unresolved, import/default */


export default angular.module('thingsboard.directives.widgetsBundleSelect', [thingsboardApiWidget])
    .directive('tbWidgetsBundleSelect', WidgetsBundleSelect)
    .name;

/*@ngInject*/
function WidgetsBundleSelect($compile, $templateCache, widgetService, types) {

    var linker = function (scope, element, attrs, ngModelCtrl) {
        var template = $templateCache.get(widgetsBundleSelectTemplate);
        element.html(template);

        scope.tbRequired = angular.isDefined(scope.tbRequired) ? scope.tbRequired : false;
        scope.widgetsBundle = null;
        scope.widgetsBundles = [];

        var widgetsBundleFetchFunction = widgetService.getAllWidgetsBundles;
        if (angular.isDefined(scope.bundlesScope)) {
            if (scope.bundlesScope === 'system') {
                widgetsBundleFetchFunction = widgetService.getSystemWidgetsBundles;
            } else if (scope.bundlesScope === 'tenant') {
                widgetsBundleFetchFunction = widgetService.getTenantWidgetsBundles;
            }
        }

        widgetsBundleFetchFunction({ignoreLoading: true}).then(
            function success(widgetsBundles) {
                scope.widgetsBundles = widgetsBundles;
                if (scope.selectFirstBundle) {
                    if (widgetsBundles.length > 0) {
                        scope.widgetsBundle = widgetsBundles[0];
                    }
                } else if (angular.isDefined(scope.selectBundleAlias)) {
                    selectWidgetsBundleByAlias(scope.selectBundleAlias);
                }
            },
            function fail() {
            }
        );

        function selectWidgetsBundleByAlias(alias) {
            if (scope.widgetsBundles && alias) {
                for (var w in scope.widgetsBundles) {
                    var widgetsBundle = scope.widgetsBundles[w];
                    if (widgetsBundle.alias === alias) {
                        scope.widgetsBundle = widgetsBundle;
                        break;
                    }
                }
            }
        }

        scope.isSystem = function(item) {
            return item && item.tenantId.id === types.id.nullUid;
        }

        scope.updateView = function () {
            ngModelCtrl.$setViewValue(scope.widgetsBundle);
        }

        ngModelCtrl.$render = function () {
            if (ngModelCtrl.$viewValue) {
                scope.widgetsBundle = ngModelCtrl.$viewValue;
            }
        }

        scope.$watch('widgetsBundle', function () {
            scope.updateView();
        });

        scope.$watch('selectBundleAlias', function (newVal, prevVal) {
            if (newVal !== prevVal) {
                selectWidgetsBundleByAlias(scope.selectBundleAlias);
            }
        });

        $compile(element.contents())(scope);
    }

    return {
        restrict: "E",
        require: "^ngModel",
        link: linker,
        scope: {
            bundlesScope: '@',
            theForm: '=?',
            tbRequired: '=?',
            selectFirstBundle: '=',
            selectBundleAlias: '=?'
        }
    };
}