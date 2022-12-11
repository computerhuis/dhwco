'use strict';

$(document).ready(function () {
    $('#personen-tabel').DataTable({
        processing: true,
        ajax: function (d, cb) {
            fetch('./api/admin/personen')
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
                    return '<a href="./admin/personen/' + data + '">' + data + '</a>';
                }
            },
            {data: 'voornaam'},
            {data: 'tussenvoegsels'},
            {data: 'achternaam'},
            {data: 'email'},
            {data: 'postcode'},
            {
                data: 'inschrijfDatum',
                render: function (data, type) {
                    if (data === null) {
                        return null;
                    }
                    return new Date(data).toLocaleDateString();
                }
            },
            {
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
