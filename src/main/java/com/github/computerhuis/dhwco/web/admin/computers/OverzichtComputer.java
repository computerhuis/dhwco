package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.model.ComputerType;

import java.time.LocalDateTime;

public record OverzichtComputer(Long nr,
                                ComputerType type,
                                String fabrikant,
                                String model,
                                LocalDateTime inboekDatum,
                                LocalDateTime uitboekDatum) {
}
