/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './user-fieldset.scss';

/* eslint-disable import/no-unresolved, import/default */

import userFieldsetTemplate from './user-fieldset.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function UserDirective($compile, $templateCache/*, dashboardService*/) {
    var linker = function (scope, element) {
        var template = $templateCache.get(userFieldsetTemplate);
        element.html(template);

        scope.isTenantAdmin = function() {
            return scope.user && scope.user.authority === 'TENANT_ADMIN';
        }

        scope.isCustomerUser = function() {
            return scope.user && scope.user.authority === 'CUSTOMER_USER';
        }

        $compile(element.contents())(scope);
    }
    return {
        restrict: "E",
        link: linker,
        scope: {
            user: '=',
            isEdit: '=',
            theForm: '=',
            onDisplayActivationLink: '&',
            onResendActivation: '&',
            onDeleteUser: '&'
        }
    };
}
