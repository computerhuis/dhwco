package com.github.computerhuis.dhwco.web.admin.bedrijven;

import com.github.computerhuis.dhwco.repository.BedrijfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/admin/bedrijven")
@RestController
class AdminBedrijvenRestController {

    private final AdminBedrijvenRestMapper bedrijfMapper;
    private final BedrijfRepository bedrijfRepository;

    @GetMapping
    public OverzichtBedrijven get() {
        return new OverzichtBedrijven(bedrijfMapper.toSet(bedrijfRepository.findAll()));
    }
}
