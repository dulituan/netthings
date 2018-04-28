/*
 * Copyright © 2016-2018 dujoy.cn
 */
import $ from 'jquery';
import 'brace/ext/language_tools';
import 'brace/mode/java';
import 'brace/theme/github';

/* eslint-disable angular/angularelement */

/*@ngInject*/
export default function EventContentDialogController($mdDialog, content, title, showingCallback) {

    var vm = this;

    showingCallback.onShowing = function(scope, element) {
        updateEditorSize(element);
    }

    vm.content = content;
    vm.title = title;

    vm.contentOptions = {
        useWrapMode: false,
        mode: 'java',
        showGutter: false,
        showPrintMargin: false,
        theme: 'github',
        advanced: {
            enableSnippets: false,
            enableBasicAutocompletion: false,
            enableLiveAutocompletion: false
        },
        onLoad: function (_ace) {
            vm.editor = _ace;
        }
    };

    function updateEditorSize(element) {
        var newHeight = 400;
        var newWidth = 600;
        if (vm.content && vm.content.length > 0) {
            var lines = vm.content.split('\n');
            newHeight = 16 * lines.length + 16;
            var maxLineLength = 0;
            for (var i in lines) {
                var line = lines[i].replace(/\t/g, '    ').replace(/\n/g, '');
                var lineLength = line.length;
                maxLineLength = Math.max(maxLineLength, lineLength);
            }
            newWidth = 8 * maxLineLength + 16;
        }
        $('#tb-event-content', element).height(newHeight.toString() + "px")
            .width(newWidth.toString() + "px");
        vm.editor.resize();
    }

    vm.close = close;

    function close () {
        $mdDialog.hide();
    }

}

/* eslint-enable angular/angularelement */
