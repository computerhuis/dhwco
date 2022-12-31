package com.github.computerhuis.dhwco.web.admin.bedrijven;

import java.time.LocalDateTime;

public record OverzichtBedrijf(Long nr,
                               String naam,
                               String woonplaats,
                               String postcode,
                               LocalDateTime inschrijfDatum,
                               LocalDateTime uitschrijfDatum) {
}
