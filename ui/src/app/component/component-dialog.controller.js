/*
 * Copyright © 2016-2018 dujoy.cn
 */
/*@ngInject*/
export default function ComponentDialogController($mdDialog, $q, $scope, componentDescriptorService, types, utils, helpLinks, isAdd, isReadOnly, componentInfo) {

    var vm = this;

    vm.isReadOnly = isReadOnly;
    vm.isAdd = isAdd;
    vm.componentInfo = componentInfo;
    if (isAdd) {
        vm.componentInfo.component = {};
    }

    vm.componentHasSchema = false;
    vm.componentDescriptors = [];

    if (vm.componentInfo.component && !vm.componentInfo.component.configuration) {
        vm.componentInfo.component.configuration = {};
    }

    vm.helpLinkIdForComponent = helpLinkIdForComponent;
    vm.save = save;
    vm.cancel = cancel;

    $scope.$watch("vm.componentInfo.component.clazz", function (newValue, prevValue) {
        if (newValue != prevValue) {
            if (newValue && prevValue) {
                vm.componentInfo.component.configuration = {};
            }
            loadComponentDescriptor();
        }
    });

    var componentDescriptorsPromise =
        vm.componentInfo.type === types.componentType.action
            ? componentDescriptorService.getPluginActionsByPluginClazz(vm.componentInfo.pluginClazz)
            : componentDescriptorService.getComponentDescriptorsByType(vm.componentInfo.type);

    componentDescriptorsPromise.then(
        function success(componentDescriptors) {
            vm.componentDescriptors = componentDescriptors;
            if (vm.componentDescriptors.length === 1 && isAdd && !vm.componentInfo.component.clazz) {
                vm.componentInfo.component.clazz = vm.componentDescriptors[0].clazz;
            }
        },
        function fail() {
        }
    );

    loadComponentDescriptor();

    function loadComponentDescriptor () {
        if (vm.componentInfo.component.clazz) {
            componentDescriptorService.getComponentDescriptorByClazz(vm.componentInfo.component.clazz).then(
                function success(componentDescriptor) {
                    vm.componentDescriptor = componentDescriptor;
                    vm.componentHasSchema = utils.isDescriptorSchemaNotEmpty(vm.componentDescriptor.configurationDescriptor);
                },
                function fail() {
                }
            );
        } else {
            vm.componentHasSchema = false;
        }
    }

    function helpLinkIdForComponent() {
        switch (vm.componentInfo.type) {
            case types.componentType.filter: {
                return helpLinks.getFilterLink(vm.componentInfo.component);
            }
            case types.componentType.processor: {
                return helpLinks.getProcessorLink(vm.componentInfo.component);
            }
            case types.componentType.action: {
                return helpLinks.getPluginActionLink(vm.componentInfo.component);
            }

        }
    }


    function cancel () {
        $mdDialog.cancel();
    }

    function save () {
        $mdDialog.hide(vm.componentInfo.component);
    }

}
