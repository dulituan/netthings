/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import rulesTemplate from './rules.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function RuleRoutes($stateProvider) {

    $stateProvider
        .state('home.rules', {
            url: '/rules',
            params: {'topIndex': 0},
            module: 'private',
            auth: ['SYS_ADMIN', 'TENANT_ADMIN'],
            views: {
                "content@home": {
                    templateUrl: rulesTemplate,
                    controllerAs: 'vm',
                    controller: 'RuleController'
                }
            },
            data: {
                searchEnabled: true,
                pageTitle: 'rule.rules'
            },
            ncyBreadcrumb: {
                label: '{"icon": "settings_ethernet", "label": "rule.rules"}'
            }
        });
}
