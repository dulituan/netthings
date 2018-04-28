/*
 * Copyright © 2016-2018 dujoy.cn
 */
/*@ngInject*/
export default function SelectTargetLayoutController($scope, $mdDialog) {

    var vm = this;

    vm.cancel = cancel;
    vm.selectLayout = selectLayout;

    function cancel() {
        $mdDialog.cancel();
    }

    function selectLayout($event, layoutId) {
        $scope.theForm.$setPristine();
        $mdDialog.hide(layoutId);
    }
}
