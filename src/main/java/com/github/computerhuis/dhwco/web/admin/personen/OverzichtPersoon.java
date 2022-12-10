package com.github.computerhuis.dhwco.web.admin.personen;

import java.time.OffsetDateTime;

public record OverzichtPersoon(Long nr,
                               String voornaam,
                               String tussenvoegsels,
                               String achternaam,
                               String email,
                               String postcode,
                               OffsetDateTime inschrijfDatum,
                               OffsetDateTime uitschrijfDatum) {
}
