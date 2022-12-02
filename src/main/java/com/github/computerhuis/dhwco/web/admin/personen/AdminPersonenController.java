package com.github.computerhuis.dhwco.web.admin.personen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/personen")
@Controller
public class AdminPersonenController {
    @GetMapping
    public String get() {
        return "/admin/personen/index";
    }
}
