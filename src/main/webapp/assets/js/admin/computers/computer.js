'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.admin = {
    computer: {
        fields: ['type',
            'voornaam',
            'fabrikant',
            'model',
            'uitboekDatum',
            'specificatie']
    }
}

computerhuis.admin.computer.laden = function () {
    let nr = $('#nr').val();
    computerhuis.api.get(
        './api/admin/computers/' + nr,
        function (data) {
            computerhuis.form.fill_auto(data);
        }
    );
    computerhuis.form.fields_enable(computerhuis.admin.computer.fields);
    computerhuis.form.submit_reset_enable();
}


$(document).ready(function () {
    computerhuis.admin.computer.laden();
});
