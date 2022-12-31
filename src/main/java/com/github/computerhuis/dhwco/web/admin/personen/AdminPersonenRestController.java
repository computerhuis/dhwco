package com.github.computerhuis.dhwco.web.admin.personen;

import com.github.computerhuis.dhwco.config.MessageSourceConfiguration;
import com.github.computerhuis.dhwco.exception.RestResponseStatusException;
import com.github.computerhuis.dhwco.model.Persoon;
import com.github.computerhuis.dhwco.repository.PersoonRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/admin/personen")
@RestController
class AdminPersonenRestController {

    private final AdminPersonenRestMapper personenMapper;
    private final PersoonRepository persoonRepository;

    @GetMapping
    public OverzichtPersonen get() {
        return new OverzichtPersonen(personenMapper.toSet(persoonRepository.findAll()));
    }

    @GetMapping("/{nr}")
    public Persoon getBedrijf(@PathVariable("nr") final long nr) {
        val persoon = persoonRepository.findById(nr);
        if (persoon.isEmpty()) {
            throw new RestResponseStatusException(HttpStatus.NOT_FOUND, MessageSourceConfiguration.getLabel("admin.persoon.exception.not_found"));
        }
        return persoon.get();
    }
}
