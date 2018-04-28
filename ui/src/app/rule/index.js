/*
 * Copyright © 2016-2018 dujoy.cn
 */
import uiRouter from 'angular-ui-router';
import thingsboardGrid from '../components/grid.directive';
import thingsboardPluginSelect from '../components/plugin-select.directive';
import thingsboardComponent from '../component';
import thingsboardApiRule from '../api/rule.service';
import thingsboardApiPlugin from '../api/plugin.service';
import thingsboardApiComponentDescriptor from '../api/component-descriptor.service';

import RuleRoutes from './rule.routes';
import RuleController from './rule.controller';
import RuleDirective from './rule.directive';

export default angular.module('thingsboard.rule', [
    uiRouter,
    thingsboardGrid,
    thingsboardPluginSelect,
    thingsboardComponent,
    thingsboardApiRule,
    thingsboardApiPlugin,
    thingsboardApiComponentDescriptor
])
    .config(RuleRoutes)
    .controller('RuleController', RuleController)
    .directive('tbRule', RuleDirective)
    .name;
