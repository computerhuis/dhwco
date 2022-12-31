'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.admin = {
    persoon: {
        fields: ['voorletters',
            'voornaam',
            'tussenvoegsels',
            'achternaam',
            'geboortedatum',
            'uitschrijfDatum',
            'telefoon',
            'mobile',
            'email',
            'straat',
            'huisnummer',
            'huisnummertoevoeging',
            'postcode',
            'woonplaats',
            'opmerkingen']
    }
}

computerhuis.admin.persoon.laden = function () {
    let nr = $('#nr').val();
    computerhuis.api.get(
        './api/admin/personen/' + nr,
        function (data) {
            computerhuis.form.fill_auto(data);
        }
    );
    computerhuis.form.fields_enable(computerhuis.admin.persoon.fields);
    computerhuis.form.submit_reset_enable();
}


$(document).ready(function () {
    computerhuis.admin.persoon.laden();
});
