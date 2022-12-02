package com.github.computerhuis.dhwco.web.admin.reparaties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/reparaties")
@Controller
public class AdminReparatiesController {
    @GetMapping
    public String get() {
        return "/admin/reparaties/index";
    }
}
