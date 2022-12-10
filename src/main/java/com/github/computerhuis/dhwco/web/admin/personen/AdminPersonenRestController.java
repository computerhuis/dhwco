package com.github.computerhuis.dhwco.web.admin.personen;

import com.github.computerhuis.dhwco.repository.PersoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
}
