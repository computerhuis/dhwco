'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.isBlank = function (value) {
    return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
}

computerhuis.csrf = function (headers) {
    headers[$("meta[name='_csrf_header']").attr("content")] = $("meta[name='_csrf']").attr("content");
    return headers;
}

computerhuis.api = {};
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
        headers: computerhuis.csrf({}),
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
