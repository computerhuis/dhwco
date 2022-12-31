package com.github.computerhuis.dhwco.web.admin.personen;

import com.github.computerhuis.dhwco.repository.PersoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin/personen")
@Controller
class AdminPersonenController {

    private final PersoonRepository persoonRepository;

    @GetMapping
    public String get() {
        return "/admin/personen/index";
    }

    @GetMapping("/{nr}")
    public String getBedrijf(@PathVariable("nr") final long nr) {
        return "/admin/personen/persoon";
    }
}
