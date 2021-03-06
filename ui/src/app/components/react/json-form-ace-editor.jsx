/*
 * Copyright © 2016-2018 dujoy.cn
 */
import './json-form-ace-editor.scss';

import React from 'react';
import ThingsboardBaseComponent from './json-form-base-component.jsx';
import reactCSS from 'reactcss';
import AceEditor from 'react-ace';
import FlatButton from 'material-ui/FlatButton';
import 'brace/ext/language_tools';
import 'brace/theme/github';

class ThingsboardAceEditor extends React.Component {

    constructor(props) {
        super(props);
        this.onValueChanged = this.onValueChanged.bind(this);
        this.onBlur = this.onBlur.bind(this);
        this.onFocus = this.onFocus.bind(this);
        this.onTidy = this.onTidy.bind(this);
        var value = props.value ? props.value + '' : '';
        this.state = {
            value: value,
            focused: false
        };
    }

    onValueChanged(value) {
        this.setState({
            value: value
        });
        this.props.onChangeValidate({
            target: {
                value: value
            }
        });
    }

    onBlur() {
        this.setState({ focused: false })
    }

    onFocus() {
        this.setState({ focused: true })
    }

    onTidy() {
        if (!this.props.form.readonly) {
            var value = this.state.value;
            value = this.props.onTidy(value);
            this.setState({
                value: value
            })
            this.props.onChangeValidate({
                target: {
                    value: value
                }
            });
        }
    }

    render() {

        const styles = reactCSS({
            'default': {
                tidyButtonStyle: {
                    color: '#7B7B7B',
                    minWidth: '32px',
                    minHeight: '15px',
                    lineHeight: '15px',
                    fontSize: '0.800rem',
                    margin: '0',
                    padding: '4px',
                    height: '23px',
                    borderRadius: '5px',
                    marginLeft: '5px'
                }
            }
        });

        var labelClass = "tb-label";
        if (this.props.form.required) {
            labelClass += " tb-required";
        }
        if (this.props.form.readonly) {
            labelClass += " tb-readonly";
        }
        if (this.state.focused) {
            labelClass += " tb-focused";
        }

        return (
            <div className="tb-container">
                <label className={labelClass}>{this.props.form.title}</label>
                <div className="json-form-ace-editor">
                    <div className="title-panel">
                        <label>{this.props.mode}</label>
                        <FlatButton style={ styles.tidyButtonStyle } className="tidy-button" label={'Tidy'} onTouchTap={this.onTidy}/>
                    </div>
                    <AceEditor mode={this.props.mode}
                               height="150px"
                               width="300px"
                               theme="github"
                               onChange={this.onValueChanged}
                               onFocus={this.onFocus}
                               onBlur={this.onBlur}
                               name={this.props.form.title}
                               value={this.state.value}
                               readOnly={this.props.form.readonly}
                               editorProps={{$blockScrolling: Infinity}}
                               enableBasicAutocompletion={true}
                               enableSnippets={true}
                               enableLiveAutocompletion={true}
                               style={this.props.form.style || {width: '100%'}}/>
                </div>
                <div className="json-form-error"
                    style={{opacity: this.props.valid ? '0' : '1'}}>{this.props.error}</div>
            </div>
        );
    }
}

export default ThingsboardBaseComponent(ThingsboardAceEditor);
