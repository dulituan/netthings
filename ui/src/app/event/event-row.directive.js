/*
 *
 */
/* eslint-disable import/no-unresolved, import/default */

import eventErrorDialogTemplate from './event-content-dialog.tpl.html';

import eventRowLcEventTemplate from './event-row-lc-event.tpl.html';
import eventRowStatsTemplate from './event-row-stats.tpl.html';
import eventRowErrorTemplate from './event-row-error.tpl.html';

/* eslint-enable import/no-unresolved, import/default */

/*@ngInject*/
export default function EventRowDirective($compile, $templateCache, $mdDialog, $document, types) {

    var linker = function (scope, element, attrs) {

        var getTemplate = function(eventType) {
            var template = '';
            switch(eventType) {
                case types.eventType.lcEvent.value:
                    template = eventRowLcEventTemplate;
                    break;
                case types.eventType.stats.value:
                    template = eventRowStatsTemplate;
                    break;
                case types.eventType.error.value:
                    template = eventRowErrorTemplate;
                    break;
            }
            return $templateCache.get(template);
        }

        scope.loadTemplate = function() {
            element.html(getTemplate(attrs.eventType));
            $compile(element.contents())(scope);
        }

        attrs.$observe('eventType', function() {
            scope.loadTemplate();
        });

        scope.event = attrs.event;

        scope.showContent = function($event, content, title) {
            var onShowingCallback = {
                onShowing: function(){}
            }
            $mdDialog.show({
                controller: 'EventContentDialogController',
                controllerAs: 'vm',
                templateUrl: eventErrorDialogTemplate,
                locals: {content: content, title: title, showingCallback: onShowingCallback},
                parent: angular.element($document[0].body),
                fullscreen: true,
                targetEvent: $event,
                skipHide: true,
                onShowing: function(scope, element) {
                    onShowingCallback.onShowing(scope, element);
                }
            });
        }

        $compile(element.contents())(scope);
    }

    return {
        restrict: "A",
        replace: false,
        link: linker,
        scope: false
    };
}
