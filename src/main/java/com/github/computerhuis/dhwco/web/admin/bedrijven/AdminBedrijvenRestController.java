package com.github.computerhuis.dhwco.web.admin.bedrijven;

import com.github.computerhuis.dhwco.model.Bedrijf;
import com.github.computerhuis.dhwco.repository.BedrijfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/admin/bedrijven")
@RestController
public class AdminBedrijvenRestController {
    private final BedrijfRepository bedrijfRepository;

    @GetMapping
    public List<Bedrijf> get() {
        return bedrijfRepository.findAll();
    }
}
