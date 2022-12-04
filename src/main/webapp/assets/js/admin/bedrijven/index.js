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
        }
    });
});
