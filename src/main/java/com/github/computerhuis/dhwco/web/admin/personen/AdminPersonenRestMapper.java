package com.github.computerhuis.dhwco.web.admin.personen;

import com.github.computerhuis.dhwco.model.Persoon;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AdminPersonenRestMapper {

    Set<OverzichtPersoon> toSet(List<Persoon> personen);

    OverzichtPersoon toSet(Persoon persoon);
}
