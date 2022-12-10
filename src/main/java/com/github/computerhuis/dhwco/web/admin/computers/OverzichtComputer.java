package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.model.ComputerType;

import java.time.OffsetDateTime;

public record OverzichtComputer(Long nr,
                                ComputerType type,
                                String fabrikant,
                                String model,
                                OffsetDateTime inboekDatum,
                                OffsetDateTime uitboekDatum) {
}
