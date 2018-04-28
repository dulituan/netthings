/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './ie.support';

import 'event-source-polyfill';

import angular from 'angular';
import ngMaterial from 'angular-material';
import ngMdIcons from 'angular-material-icons';
import ngCookies from 'angular-cookies';
import angularSocialshare from 'angular-socialshare';
import 'angular-translate';
import 'angular-translate-loader-static-files';
import 'angular-translate-storage-local';
import 'angular-translate-storage-cookie';
import 'angular-translate-handler-log';
import 'angular-translate-interpolation-messageformat';
import 'md-color-picker';
import mdPickers from 'mdPickers';
import ngSanitize from 'angular-sanitize';
import vAccordion from 'v-accordion';
import ngAnimate from 'angular-animate';
import 'angular-websocket';
import uiRouter from 'angular-ui-router';
import angularJwt from 'angular-jwt';
import 'angular-drag-and-drop-lists';
import mdDataTable from 'angular-material-data-table';
import 'angular-material-expansion-panel';
import ngTouch from 'angular-touch';
import 'angular-carousel';
import 'clipboard';
import 'ngclipboard';
import 'react';
import 'react-dom';
import 'material-ui';
import 'react-schema-form';
import react from 'ngreact';
import '@flowjs/ng-flow/dist/ng-flow-standalone.min';

import thingsboardLocales from './locale/locale.constant';
import thingsboardLogin from './login';
import thingsboardDialogs from './components/datakey-config-dialog.controller';
import thingsboardMenu from './services/menu.service';
import thingsboardRaf from './common/raf.provider';
import thingsboardUtils from './common/utils.service';
import thingsboardDashboardUtils from './common/dashboard-utils.service';
import thingsboardTypes from './common/types.constant';
import thingsboardApiTime from './api/time.service';
import thingsboardKeyboardShortcut from './components/keyboard-shortcut.filter';
import thingsboardHelp from './help/help.directive';
import thingsboardToast from './services/toast';
import thingsboardClipboard from './services/clipboard.service';
import thingsboardHome from './layout';
import thingsboardApiLogin from './api/login.service';
import thingsboardApiDevice from './api/device.service';
import thingsboardApiUser from './api/user.service';
import thingsboardApiEntityRelation from './api/entity-relation.service';
import thingsboardApiAsset from './api/asset.service';
import thingsboardApiAttribute from './api/attribute.service';
import thingsboardApiEntity from './api/entity.service';
import thingsboardApiAlarm from './api/alarm.service';
import thingsboardApiAuditLog from './api/audit-log.service';

import 'typeface-roboto';
import 'font-awesome/css/font-awesome.min.css';
import 'angular-material/angular-material.min.css';
import 'angular-material-icons/angular-material-icons.css';
import 'angular-gridster/dist/angular-gridster.min.css';
import 'v-accordion/dist/v-accordion.min.css'
import 'md-color-picker/dist/mdColorPicker.min.css';
import 'mdPickers/dist/mdPickers.min.css';
import 'angular-hotkeys/build/hotkeys.min.css';
import 'angular-carousel/dist/angular-carousel.min.css';
import 'angular-material-expansion-panel/dist/md-expansion-panel.min.css';
import '../scss/main.scss';

import AppConfig from './app.config';
import GlobalInterceptor from './global-interceptor.service';
import AppRun from './app.run';

angular.module('dujoyIOT', [
    ngMaterial,
    ngMdIcons,
    ngCookies,
    angularSocialshare,
    'pascalprecht.translate',
    'mdColorPicker',
    mdPickers,
    ngSanitize,
    vAccordion,
    ngAnimate,
    'ngWebSocket',
    angularJwt,
    'dndLists',
    mdDataTable,
    'material.components.expansionPanels',
    ngTouch,
    'angular-carousel',
    'ngclipboard',
    react.name,
    'flow',
    thingsboardLocales,
    thingsboardLogin,
    thingsboardDialogs,
    thingsboardMenu,
    thingsboardRaf,
    thingsboardUtils,
    thingsboardDashboardUtils,
    thingsboardTypes,
    thingsboardApiTime,
    thingsboardKeyboardShortcut,
    thingsboardHelp,
    thingsboardToast,
    thingsboardClipboard,
    thingsboardHome,
    thingsboardApiLogin,
    thingsboardApiDevice,
    thingsboardApiUser,
    thingsboardApiEntityRelation,
    thingsboardApiAsset,
    thingsboardApiAttribute,
    thingsboardApiEntity,
    thingsboardApiAlarm,
    thingsboardApiAuditLog,
    uiRouter])
    .config(AppConfig)
    .factory('globalInterceptor', GlobalInterceptor)
    .run(AppRun);
