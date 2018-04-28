/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import componentDialogTemplate from './component-dialog.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function ComponentDialogService($mdDialog, $document, $q) {

    var service = {
        openComponentDialog: openComponentDialog
    }

    return service;

    function openComponentDialog($event, isAdd, readOnly, title, type, pluginClazz, component) {
        var deferred = $q.defer();
        var componentInfo = {
            title: title,
            type: type,
            pluginClazz: pluginClazz
        };
        if (component) {
            componentInfo.component = angular.copy(component);
        }
        $mdDialog.show({
            controller: 'ComponentDialogController',
            controllerAs: 'vm',
            templateUrl: componentDialogTemplate,
            locals: {isAdd: isAdd,
                isReadOnly: readOnly,
                componentInfo: componentInfo},
            parent: angular.element($document[0].body),
            fullscreen: true,
            targetEvent: $event,
            skipHide: true
        }).then(function (component) {
            deferred.resolve(component);
        }, function () {
            deferred.reject();
        });
        return deferred.promise;
    }

}