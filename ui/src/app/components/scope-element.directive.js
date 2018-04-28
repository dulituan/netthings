/*
 * Copyright © 2016-2018 dujoy.cn
 */
export default angular.module('thingsboard.directives.scopeElement', [])
    .directive('tbScopeElement', ScopeElement)
    .name;

/*@ngInject*/
function ScopeElement() {
    var directiveDefinitionObject = {
        restrict: "A",
        compile: function compile() {
            return {
                pre: function preLink(scope, iElement, iAttrs) {
                    scope[iAttrs.tbScopeElement] = iElement;
                }
            };
        }
    };
    return directiveDefinitionObject;
}
