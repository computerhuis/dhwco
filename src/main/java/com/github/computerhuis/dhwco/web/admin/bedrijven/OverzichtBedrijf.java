package com.github.computerhuis.dhwco.web.admin.bedrijven;

import java.time.OffsetDateTime;

public record OverzichtBedrijf(Long nr,
                               String naam,
                               String woonplaats,
                               String postcode,
                               OffsetDateTime inschrijfDatum,
                               OffsetDateTime uitschrijfDatum) {
}
