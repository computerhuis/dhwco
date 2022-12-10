package com.github.computerhuis.dhwco.web.admin.bedrijven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/bedrijven")
@Controller
class AdminBedrijvenController {
    @GetMapping
    public String get() {
        return "/admin/bedrijven/index";
    }
}
