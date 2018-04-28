/*
 * Copyright © 2016-2018 dujoy.cn
 */
import ManageDashboardLayoutsController from './manage-dashboard-layouts.controller';
import SelectTargetLayoutController from './select-target-layout.controller';
import DashboardLayoutDirective from './dashboard-layout.directive';

export default angular.module('thingsboard.dashboard.layouts', [])
    .controller('ManageDashboardLayoutsController', ManageDashboardLayoutsController)
    .controller('SelectTargetLayoutController', SelectTargetLayoutController)
    .directive('tbDashboardLayout', DashboardLayoutDirective)
    .name;
