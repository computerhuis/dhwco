package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.model.Computer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AdminComputersRestMapper {
    Set<OverzichtComputer> toSet(List<Computer> all);
}
