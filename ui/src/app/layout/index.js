/*
 *
 */
import './home.scss';

import uiRouter from 'angular-ui-router';
import ngSanitize from 'angular-sanitize';
import FBAngular from 'angular-fullscreen';
import 'angular-breadcrumb';

import thingsboardMenu from '../services/menu.service';
import thingsboardApiDevice from '../api/device.service';
import thingsboardApiLogin from '../api/login.service';
import thingsboardApiUser from '../api/user.service';

import thingsboardNoAnimate from '../components/no-animate.directive';
import thingsboardOnFinishRender from '../components/finish-render.directive';
import thingsboardSideMenu from '../components/side-menu.directive';
import thingsboardDashboardAutocomplete from '../components/dashboard-autocomplete.directive';

import thingsboardUserMenu from './user-menu.directive';

import thingsboardEntity from '../entity';
import thingsboardEvent from '../event';
import thingsboardAlarm from '../alarm';
import thingsboardAuditLog from '../audit';
import thingsboardExtension from '../extension';
import thingsboardTenant from '../tenant';
import thingsboardCustomer from '../customer';
import thingsboardUser from '../user';
import thingsboardHomeLinks from '../home';
import thingsboardAdmin from '../admin';
import thingsboardProfile from '../profile';
import thingsboardAsset from '../asset';
import thingsboardDevice from '../device';
import thingsboardWidgetLibrary from '../widget';
import thingsboardDashboard from '../dashboard';
import thingsboardPlugin from '../plugin';
import thingsboardRule from '../rule';

import thingsboardJsonForm from '../jsonform';

import HomeRoutes from './home.routes';
import HomeController from './home.controller';
import BreadcrumbLabel from './breadcrumb-label.filter';
import BreadcrumbIcon from './breadcrumb-icon.filter';

export default angular.module('thingsboard.home', [
    uiRouter,
    ngSanitize,
    FBAngular.name,
    'ncy-angular-breadcrumb',
    thingsboardMenu,
    thingsboardHomeLinks,
    thingsboardUserMenu,
    thingsboardEntity,
    thingsboardEvent,
    thingsboardAlarm,
    thingsboardAuditLog,
    thingsboardExtension,
    thingsboardTenant,
    thingsboardCustomer,
    thingsboardUser,
    thingsboardAdmin,
    thingsboardProfile,
    thingsboardAsset,
    thingsboardDevice,
    thingsboardWidgetLibrary,
    thingsboardDashboard,
    thingsboardPlugin,
    thingsboardRule,
    thingsboardJsonForm,
    thingsboardApiDevice,
    thingsboardApiLogin,
    thingsboardApiUser,
    thingsboardNoAnimate,
    thingsboardOnFinishRender,
    thingsboardSideMenu,
    thingsboardDashboardAutocomplete
])
    .config(HomeRoutes)
    .controller('HomeController', HomeController)
    .filter('breadcrumbLabel', BreadcrumbLabel)
    .filter('breadcrumbIcon', BreadcrumbIcon)
    .name;
