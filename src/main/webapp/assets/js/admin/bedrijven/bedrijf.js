'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.admin = {
    bedrijven: {
        fields: ['naam',
            'kvk_nummer',
            'btw_nummer',
            'uitschrijfDatum',
            'telefoon',
            'email',
            'website',
            'straat',
            'huisnummer',
            'huisnummertoevoeging',
            'postcode',
            'woonplaats',
            'opmerkingen']
    }
}

computerhuis.admin.bedrijven.laden = function () {
    let nr = $('#nr').val();
    computerhuis.api.get(
        './api/admin/bedrijven/' + nr,
        function (data) {
            computerhuis.form.fill_auto(data);
        }
    );
    computerhuis.form.fields_enable(computerhuis.admin.bedrijven.fields);
    computerhuis.form.submit_reset_enable();
}

$(document).ready(function () {
    computerhuis.admin.bedrijven.laden();
});
