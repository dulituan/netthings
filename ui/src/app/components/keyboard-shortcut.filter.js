/*
 * Copyright © 2016-2018 dujoy.cn
 */
export default angular.module('thingsboard.filters.keyboardShortcut', [])
    .filter('keyboardShortcut', KeyboardShortcut)
    .name;

/*@ngInject*/
function KeyboardShortcut($window) {
    return function(str) {
        if (!str) return;
        var keys = str.split('-');
        var isOSX = /Mac OS X/.test($window.navigator.userAgent);

        var seperator = (!isOSX || keys.length > 2) ? '+' : '';

        var abbreviations = {
            M: isOSX ? '⌘' : 'Ctrl',
            A: isOSX ? 'Option' : 'Alt',
            S: 'Shift'
        };

        return keys.map(function(key, index) {
            var last = index == keys.length - 1;
            return last ? key : abbreviations[key];
        }).join(seperator);
    };
}
