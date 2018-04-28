/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './toast.scss';

import Toast from './toast.service';
import ToastController from './toast.controller';

export default angular.module('thingsboard.toast', [])
    .factory('toast', Toast)
    .controller('ToastController', ToastController)
    .name;
