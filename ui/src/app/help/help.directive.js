/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './help.scss';

import thingsboardHelpLinks from './help-links.constant';

import $ from 'jquery';

export default angular.module('thingsboard.directives.help', [thingsboardHelpLinks])
    .directive('tbHelp', Help)
    .name;

/* eslint-disable angular/angularelement */

/*@ngInject*/
function Help($compile, $window, helpLinks) {

    var linker = function (scope, element, attrs) {

        scope.gotoHelpPage = function ($event) {
            if ($event) {
                $event.stopPropagation();
            }
            var helpUrl = helpLinks.linksMap[scope.helpLinkId];
            if (helpUrl) {
                $window.open(helpUrl, '_blank');
            }
        }

        var html = '<md-tooltip md-direction="top">' +
            '{{\'help.goto-help-page\' | translate}}' +
            '</md-tooltip>' +
            '<md-icon class="material-icons">' +
                'help' +
            '</md-icon>';

        var helpButton = angular.element('<md-button class="tb-help-button-style tb-help-button-pos md-icon-button" ' +
            'ng-click="gotoHelpPage($event)">' +
            html +
            '</md-button>');

        if (attrs.helpContainerId) {
            var helpContainer = $('#' + attrs.helpContainerId, element)[0];
            helpContainer = angular.element(helpContainer);
            helpContainer.append(helpButton);
            $compile(helpContainer.contents())(scope);
        } else {
            $compile(helpButton)(scope);
            element.append(helpButton);
        }
    }

    return {
        restrict: "A",
        link: linker,
        scope: {
            helpLinkId: "=tbHelp"
        }
    };
}

/* eslint-enable angular/angularelement */
