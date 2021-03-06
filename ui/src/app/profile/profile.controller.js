/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import changePasswordTemplate from './change-password.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function ProfileController(userService, $scope, $document, $mdDialog, $translate) {
    var vm = this;

    vm.profileUser = {};

    vm.save = save;
    vm.changePassword = changePassword;
    vm.languageList = {
        en_US: {value : "en_US", name: "language.en_US"}, 
        ko_KR: {value : "ko_KR", name: "language.ko_KR"},
        zh_CN: {value : "zh_CN", name: "language.zh_CN"},
        ru_RU: {value : "ru_RU", name: "language.ru_RU"},
        es_ES: {value : "es_ES", name: "language.es_ES"},
    };

    loadProfile();

    function loadProfile() {
        userService.getUser(userService.getCurrentUser().userId).then(function success(user) {
            vm.profileUser = user;
            if (!vm.profileUser.additionalInfo) {
                vm.profileUser.additionalInfo = {};
            }
            if (!vm.profileUser.additionalInfo.lang) {
                vm.profileUser.additionalInfo.lang = $translate.use();
            }
        });
    }

    function save() {
        userService.saveUser(vm.profileUser).then(function success(user) {
            $translate.use(vm.profileUser.additionalInfo.lang);
            vm.profileUser = user;
            $scope.theForm.$setPristine();
        });
    }

    function changePassword($event) {
        $mdDialog.show({
            controller: 'ChangePasswordController',
            controllerAs: 'vm',
            templateUrl: changePasswordTemplate,
            parent: angular.element($document[0].body),
            fullscreen: true,
            targetEvent: $event
        }).then(function () {
        }, function () {
        });
    }
}
