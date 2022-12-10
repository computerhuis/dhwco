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
            {data: 'nr'},
            {data: 'naam'},
            {data: 'woonplaats'},
            {data: 'postcode'},
            {
                data: 'inschrijfDatum',
                render: function (data, type) {
                    return new Date(data).toLocaleDateString();
                }
            }, {
                data: 'uitschrijfDatum',
                render: function (data, type) {
                    return new Date(data).toLocaleDateString();
                }
            }
        ]
    });
});
