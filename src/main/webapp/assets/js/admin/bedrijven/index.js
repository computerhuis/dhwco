'use strict';

$(document).ready(function () {
    $('#bedrijven-tabel').DataTable({
        processing: true,
        ajax: function (d, cb) {
            fetch('./api/admin/bedrijven')
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
                    return '<a href="./admin/bedrijven/' + data + '">' + data + '</a>';
                }
            },
            {data: 'naam'},
            {data: 'woonplaats'},
            {data: 'postcode'},
            {
                data: 'inschrijfDatum',
                render: function (data, type) {
                    if (data === null) {
                        return null;
                    }
                    return new Date(data).toLocaleDateString();
                }
            }, {
                data: 'uitschrijfDatum',
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
