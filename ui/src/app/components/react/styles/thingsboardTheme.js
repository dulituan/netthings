/*
 * Copyright © 2016-2018 dujoy.cn
 */
import { /*blueGrey500, blueGrey700, blueGrey100, orange500,*/
         grey100, grey500, grey900, grey600, white, grey400, darkBlack, cyan500, fullBlack/*, indigo500*/, indigo700, indigo100, deepOrange500 } from 'material-ui/styles/colors';
import {fade} from 'material-ui/utils/colorManipulator';
import spacing from 'material-ui/styles/spacing';

const PRIMARY_BACKGROUND_COLOR = "#305680";//"#3f51b5";

/*var blueGrayPalette = {
    primary1Color: blueGrey500,
    primary2Color: blueGrey700,
    primary3Color: blueGrey100,
    accent1Color: orange500,
    accent2Color: grey100,
    accent3Color: grey500,
    textColor: grey900,
    secondaryTextColor: grey600,
    alternateTextColor: white,
    canvasColor: white,
    borderColor: grey400,
    disabledColor: fade(darkBlack, 0.3),
    pickerHeaderColor: cyan500,
    clockCircleColor: fade(darkBlack, 0.07),
    shadowColor: fullBlack,
};*/

var indigoPalette = {
    primary1Color: PRIMARY_BACKGROUND_COLOR,
    primary2Color: indigo700,
    primary3Color: indigo100,
    accent1Color: deepOrange500,
    accent2Color: grey100,
    accent3Color: grey500,
    textColor: grey900,
    secondaryTextColor: grey600,
    alternateTextColor: white,
    canvasColor: white,
    borderColor: grey400,
    disabledColor: fade(darkBlack, 0.3),
    pickerHeaderColor: cyan500,
    clockCircleColor: fade(darkBlack, 0.07),
    shadowColor: fullBlack,
};

export default {
    spacing: spacing,
    fontFamily: 'Roboto, \'Helvetica Neue\', sans-serif',
    palette: indigoPalette,
};