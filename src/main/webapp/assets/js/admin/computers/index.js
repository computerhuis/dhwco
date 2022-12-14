'use strict';

$(document).ready(function () {
    $('#computers-tabel').DataTable({
        processing: true,
        ajax: function (d, cb) {
            fetch('./api/admin/computers')
                .then(response => response.json())
                .then(data => cb(data));
        },
        language: {
            url: './assets/js/datatable/nl-NL.json'
        },
        columns: [
            {
                data: 'nr',
                render: function (data, type) {
                    if (data === null) {
                        return null;
                    }
                    return '<a href="./admin/computers/' + data + '">' + data + '</a>';
                }
            },
            {data: 'type'},
            {data: 'fabrikant'},
            {data: 'model'},
            {
                data: 'inboekDatum',
                render: function (data, type) {
                    if (data === null) {
                        return null;
                    }
                    return new Date(data).toLocaleDateString();
                }
            },
            {
                data: 'uitboekDatum',
                render: function (data, type) {
                    if (data === null) {
                        return null;
                    }
                    return new Date(data).toLocaleDateString();
                }
            }
        ]
    });
});
