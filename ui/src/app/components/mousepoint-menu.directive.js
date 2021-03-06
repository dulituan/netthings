/*
 * Copyright © 2016-2018 dujoy.cn
 */
export default angular.module('thingsboard.directives.mousepointMenu', [])
    .directive('tbMousepointMenu', MousepointMenu)
    .name;

/*@ngInject*/
function MousepointMenu() {

    var linker = function ($scope, $element, $attrs, RightClickContextMenu) {

        $scope.$mdOpenMousepointMenu = function($event){
            RightClickContextMenu.offsets = function(){
                var offset = $element.offset();
                var x = $event.pageX - offset.left;
                var y = $event.pageY - offset.top;

                var offsets = {
                    left: x,
                    top: y
                }
                return offsets;
            }
            RightClickContextMenu.open($event);
        };

        $scope.$mdCloseMousepointMenu = function() {
            RightClickContextMenu.close();
        }
    }

    return {
        restrict: "A",
        link: linker,
        require: 'mdMenu'
    };
}
