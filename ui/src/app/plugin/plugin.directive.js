/*
 *
 */
import './plugin.scss';

/* eslint-disable import/no-unresolved, import/default */

import pluginFieldsetTemplate from './plugin-fieldset.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function PluginDirective($compile, $templateCache, $translate, types, toast, utils, userService, componentDescriptorService) {
    var linker = function (scope, element) {
        var template = $templateCache.get(pluginFieldsetTemplate);
        element.html(template);

        scope.showPluginConfig = false;

        scope.pluginConfiguration = {
            data: null
        };

        if (scope.plugin && !scope.plugin.configuration) {
            scope.plugin.configuration = {};
        }

        scope.$watch("plugin.clazz", function (newValue, prevValue) {
            if (newValue != prevValue) {
                scope.pluginConfiguration.data = null;
                if (scope.plugin) {
                    componentDescriptorService.getComponentDescriptorByClazz(scope.plugin.clazz).then(
                        function success(component) {
                            scope.pluginComponent = component;
                            scope.showPluginConfig = !(userService.getAuthority() === 'TENANT_ADMIN'
                                                        && scope.plugin.tenantId
                                                        && scope.plugin.tenantId.id === types.id.nullUid)
                                                      && utils.isDescriptorSchemaNotEmpty(scope.pluginComponent.configurationDescriptor);
                            scope.pluginConfiguration.data = angular.copy(scope.plugin.configuration);
                        },
                        function fail() {
                        }
                    );
                }
            }
        });

        scope.$watch("pluginConfiguration.data", function (newValue, prevValue) {
            if (newValue && !angular.equals(newValue, prevValue)) {
                scope.plugin.configuration = angular.copy(scope.pluginConfiguration.data);
            }
        }, true);

        scope.onPluginIdCopied = function() {
            toast.showSuccess($translate.instant('plugin.idCopiedMessage'), 750, angular.element(element).parent().parent(), 'bottom left');
        };

        componentDescriptorService.getComponentDescriptorsByType(types.componentType.plugin).then(
            function success(components) {
                scope.pluginComponents = components;
            },
            function fail() {
            }
        );

        $compile(element.contents())(scope);
    }
    return {
        restrict: "E",
        link: linker,
        scope: {
            plugin: '=',
            isEdit: '=',
            isReadOnly: '=',
            theForm: '=',
            onActivatePlugin: '&',
            onSuspendPlugin: '&',
            onExportPlugin: '&',
            onDeletePlugin: '&'
        }
    };
}
