/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import activationLinkDialogTemplate from './activation-link.dialog.tpl.html';

/* eslint-enable import/no-unresolved, import/default */


/*@ngInject*/
export default function AddUserController($scope, $mdDialog, $state, $stateParams, $document, $q, types, userService, saveItemFunction, helpLinks) {

    var vm = this;

    var tenantId = $stateParams.tenantId;
    var customerId = $stateParams.customerId;
    var usersType = $state.$current.data.usersType;

    vm.helpLinks = helpLinks;
    vm.item = {};

    vm.activationMethods = [
        {
            value: 'displayActivationLink',
            name: 'user.display-activation-link'
        },
        {
            value: 'sendActivationMail',
            name: 'user.send-activation-mail'
        }
    ];

    vm.userActivationMethod = 'displayActivationLink';

    vm.add = add;
    vm.cancel = cancel;

    function cancel() {
        $mdDialog.cancel();
    }

    function add($event) {
        var sendActivationMail = false;
        if (vm.userActivationMethod == 'sendActivationMail') {
            sendActivationMail = true;
        }
        if (usersType === 'tenant') {
            vm.item.authority = "TENANT_ADMIN";
            vm.item.tenantId = {
                entityType: types.entityType.tenant,
                id: tenantId
            };
        } else if (usersType === 'customer') {
            vm.item.authority = "CUSTOMER_USER";
            vm.item.customerId = {
                entityType: types.entityType.customer,
                id: customerId
            };
        }
        userService.saveUser(vm.item, sendActivationMail).then(function success(item) {
            vm.item = item;
            $scope.theForm.$setPristine();
            if (vm.userActivationMethod == 'displayActivationLink') {
                userService.getActivationLink(vm.item.id.id).then(
                    function success(activationLink) {
                        displayActivationLink($event, activationLink).then(
                            function() {
                                $mdDialog.hide();
                            }
                        );
                    }
                );
            } else {
                $mdDialog.hide();
            }
        });
    }

    function displayActivationLink($event, activationLink) {
        var deferred = $q.defer();
        $mdDialog.show({
            controller: 'ActivationLinkDialogController',
            controllerAs: 'vm',
            templateUrl: activationLinkDialogTemplate,
            locals: {
                activationLink: activationLink
            },
            parent: angular.element($document[0].body),
            fullscreen: true,
            skipHide: true,
            targetEvent: $event
        }).then(function () {
            deferred.resolve();
        });
        return deferred.promise;
    }

}