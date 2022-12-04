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
        }
    });
});
