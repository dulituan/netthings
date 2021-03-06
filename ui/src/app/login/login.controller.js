/*
 * Copyright © 2016-2018 dujoy.cn
 */
/* eslint-disable import/no-unresolved, import/default */

import logoSvg from '../../svg/logo_title_white.svg';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function LoginController(toast, loginService, userService/*, $rootScope, $log, $translate*/) {
    var vm = this;

    vm.logoSvg = logoSvg;

    vm.user = {
        name: '',
        password: ''
    };

    vm.login = login;

    function doLogin() {
        loginService.login(vm.user).then(function success(response) {
            var token = response.data.token;
            var refreshToken = response.data.refreshToken;
            userService.setUserFromJwtToken(token, refreshToken, true);
        }, function fail(/*response*/) {
            /*if (response && response.data && response.data.message) {
                toast.showError(response.data.message);
            } else if (response && response.statusText) {
                toast.showError(response.statusText);
            } else {
                toast.showError($translate.instant('error.unknown-error'));
            }*/
        });
    }

    function login() {
        doLogin();
    }
}
