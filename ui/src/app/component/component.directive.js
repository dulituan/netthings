/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import componentTemplate from './component.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function ComponentDirective($compile, $templateCache, $document, $mdDialog, componentDialogService, componentDescriptorService) {

    var linker = function (scope, element) {

        var template = $templateCache.get(componentTemplate);

        element.html(template);

        scope.componentTypeName = '';

        scope.loadComponentTypeName = function () {
            componentDescriptorService.getComponentDescriptorByClazz(scope.component.clazz).then(
                function success(component) {
                    scope.componentTypeName = component.name;
                },
                function fail() {}
            );
        }

        scope.$watch('component', function(newVal) {
                if (newVal) {
                    scope.loadComponentTypeName();
                }
            }
        );

        scope.openComponent = function($event) {
            componentDialogService.openComponentDialog($event, false,
                scope.readOnly, scope.title, scope.type, scope.pluginClazz,
                angular.copy(scope.component)).then(
                    function success(component) {
                        scope.component = component;
                    },
                    function fail() {}
            );
        }

        $compile(element.contents())(scope);
    }

    return {
        restrict: "E",
        link: linker,
        scope: {
            component: '=',
            type: '=',
            pluginClazz: '=',
            title: '@',
            readOnly: '=',
            onRemoveComponent: '&'
        }
    };
}
