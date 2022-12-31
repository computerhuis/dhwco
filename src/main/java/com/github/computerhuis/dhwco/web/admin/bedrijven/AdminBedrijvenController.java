package com.github.computerhuis.dhwco.web.admin.bedrijven;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin/bedrijven")
@Controller
class AdminBedrijvenController {

    @GetMapping
    public String get() {
        return "/admin/bedrijven/index";
    }

    @GetMapping("/{nr}")
    public String getBedrijf(@PathVariable("nr") final long nr) {
        return "/admin/bedrijven/bedrijf";
    }
}
