package com.github.computerhuis.dhwco.web.admin.personen;

import java.time.LocalDateTime;

public record OverzichtPersoon(Long nr,
                               String voornaam,
                               String tussenvoegsels,
                               String achternaam,
                               String email,
                               String postcode,
                               LocalDateTime inschrijfDatum,
                               LocalDateTime uitschrijfDatum) {
}
