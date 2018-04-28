/*
 *
 */
import thingsboardApiComponentDescriptor from '../api/component-descriptor.service';

import ComponentDialogService from './component-dialog.service';
import ComponentDialogController from './component-dialog.controller';
import ComponentDirective from './component.directive';

export default angular.module('thingsboard.component', [
    thingsboardApiComponentDescriptor
])
    .factory('componentDialogService', ComponentDialogService)
    .controller('ComponentDialogController', ComponentDialogController)
    .directive('tbComponent', ComponentDirective)
    .name;
