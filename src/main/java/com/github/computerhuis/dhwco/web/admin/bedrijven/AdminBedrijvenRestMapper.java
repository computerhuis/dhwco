package com.github.computerhuis.dhwco.web.admin.bedrijven;

import com.github.computerhuis.dhwco.model.Bedrijf;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AdminBedrijvenRestMapper {

    Set<OverzichtBedrijf> toSet(List<Bedrijf> bedrijven);

    OverzichtBedrijf toSet(Bedrijf bedrijf);
}
