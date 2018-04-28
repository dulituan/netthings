/*
 * Copyright © 2016-2018 dujoy.cn
 */
import React from 'react';
import ThingsboardBaseComponent from './json-form-base-component.jsx';
import NumberInput from 'material-ui-number-input';

class ThingsboardNumber extends React.Component {

    constructor(props) {
        super(props);
        this.preValidationCheck = this.preValidationCheck.bind(this);
        this.onBlur = this.onBlur.bind(this);
        this.onFocus = this.onFocus.bind(this);
        this.state = {
            lastSuccessfulValue : this.props.value,
            focused: false
        }
    }

    isNumeric(n) {
        return n === null || n === '' || !isNaN(n) && isFinite(n);
    }

    onBlur() {
        this.setState({ focused: false })
    }

    onFocus() {
        this.setState({ focused: true })
    }

    preValidationCheck(e) {
        if (this.isNumeric(e.target.value)) {
            this.setState({
                lastSuccessfulValue: e.target.value
            });
            this.props.onChangeValidate(e);
        }
    }

    render() {

        var fieldClass = "tb-field";
        if (this.props.form.required) {
            fieldClass += " tb-required";
        }
        if (this.props.form.readonly) {
            fieldClass += " tb-readonly";
        }
        if (this.state.focused) {
            fieldClass += " tb-focused";
        }
        var value = this.state.lastSuccessfulValue;
        if (typeof value !== 'undefined') {
            value = Number(value);
        } else {
            value = null;
        }
        return (
            <NumberInput
                className={fieldClass}
                strategy="allow"
                floatingLabelText={this.props.form.title}
                hintText={this.props.form.placeholder}
                errorText={this.props.error}
                onChange={this.preValidationCheck}
                defaultValue={value}
                ref="numberField"
                disabled={this.props.form.readonly}
                onFocus={this.onFocus}
                onBlur={this.onBlur}
                style={this.props.form.style || {width: '100%'}}/>
        );
    }
}

export default ThingsboardBaseComponent(ThingsboardNumber);