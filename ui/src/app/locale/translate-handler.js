/*
 *
 */
/*@ngInject*/
export default function ThingsboardMissingTranslateHandler($log, types) {

    return function (translationId) {
        if (translationId && !translationId.startsWith(types.translate.customTranslationsPrefix)) {
            $log.warn('Translation for ' + translationId + ' doesn\'t exist');
        }
    };

}