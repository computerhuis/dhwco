'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.isBlank = function (value) {
    return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
}

/* ------------------------------------------------------------------------------------------------------------------ */
/* API                                                                                                                */
/* ------------------------------------------------------------------------------------------------------------------ */
computerhuis.api = {};

computerhuis.api.csrf = function (headers) {
    headers['X-CSRF-TOKEN'] = $("#_csrf").val();
    return headers;
}

computerhuis.api.get = function (url, successCallback, data = null) {
    $.get({
        url: url,
        data: data,
        contentType: 'application/json',
        statusCode: computerhuis.api.statusCode(successCallback)
    });
}

computerhuis.api.put = function (url, data, successCallback) {
    computerhuis.api.ajax('PUT', url, data, successCallback);
}

computerhuis.api.post = function (url, data, successCallback) {
    computerhuis.api.ajax('POST', url, data, successCallback);
}

computerhuis.api.delete = function (url, data, successCallback) {
    computerhuis.api.ajax('DELETE', url, data, successCallback);
}

computerhuis.api.ajax = function (method, url, data, successCallback) {
    $.ajax({
        type: method,
        url: url,
        contentType: 'application/json',
        headers: computerhuis.api.csrf({}),
        dataType: 'json',
        data: JSON.stringify(data),
        statusCode: computerhuis.api.statusCode(successCallback)
    });
}

computerhuis.api.statusCode = function (successCallback) {
    return {
        200: successCallback,
        403: function (response) {
            alert(response)
            return false;
        },
        406: function (response) {
            alert(response)
            return false;
        },
        413: function (response) {
            alert(response)
            return false;
        },
        415: function (response) {
            alert(response)
            return false;
        },
        500: function (response) {
            alert(response)
            return false;
        }
    }
}

/* ------------------------------------------------------------------------------------------------------------------ */
/* FORM                                                                                                               */
/* ------------------------------------------------------------------------------------------------------------------ */
computerhuis.form = {};

computerhuis.form.fields_enable = function (fields) {
    fields.forEach((item) => {
        $('#' + item).removeAttr('disabled');
    });
}

computerhuis.form.fields_disable = function (fields) {
    fields.forEach((item) => {
        $('#' + item).attr('disabled', true);
    });
}

computerhuis.form.submit_reset_enable = function () {
    $('#reset').removeAttr('disabled');
    $('#submit_spinner').addClass('visually-hidden');
    $('#submit').removeAttr('disabled');
}

computerhuis.form.submit_reset_disable = function () {
    $('#reset').attr('disabled', true);
    $('#submit').attr('disabled', true);
    $('#submit_spinner').removeClass('visually-hidden');
}

computerhuis.form.fill_auto = function (entyset, excludes = []) {
    Object.entries(entyset).forEach(([key, value]) => {
        if (!excludes.includes(key)) {
            let field = $('#' + key);
            let type = field.attr('type');
            console.log('For field [' + key + '] detected type [' + type + ']: [' + value + ']');
            if (type === 'radio') {

            } else if (type === 'select') {

            } else {
                if (!computerhuis.isBlank(value)) {
                    field.val(value);
                }
            }
        }
    });
}
