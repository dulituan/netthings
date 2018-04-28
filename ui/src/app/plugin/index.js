/*
 *
 */
import uiRouter from 'angular-ui-router';
import thingsboardGrid from '../components/grid.directive';
import thingsboardJsonForm from '../components/json-form.directive';
import thingsboardApiPlugin from '../api/plugin.service';
import thingsboardApiComponentDescriptor from '../api/component-descriptor.service';

import PluginRoutes from './plugin.routes';
import PluginController from './plugin.controller';
import PluginDirective from './plugin.directive';

export default angular.module('thingsboard.plugin', [
    uiRouter,
    thingsboardGrid,
    thingsboardJsonForm,
    thingsboardApiPlugin,
    thingsboardApiComponentDescriptor
])
    .config(PluginRoutes)
    .controller('PluginController', PluginController)
    .directive('tbPlugin', PluginDirective)
    .name;
