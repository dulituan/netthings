/*
 *
 */
/* eslint-disable import/no-unresolved, import/default */

import pluginsTemplate from './plugins.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function PluginRoutes($stateProvider) {

    $stateProvider
        .state('home.plugins', {
            url: '/plugins',
            params: {'topIndex': 0},
            module: 'private',
            auth: ['SYS_ADMIN', 'TENANT_ADMIN'],
            views: {
                "content@home": {
                    templateUrl: pluginsTemplate,
                    controllerAs: 'vm',
                    controller: 'PluginController'
                }
            },
            data: {
                searchEnabled: true,
                pageTitle: 'plugin.plugins'
            },
            ncyBreadcrumb: {
                label: '{"icon": "extension", "label": "plugin.plugins"}'
            }
        });
}
