package com.github.computerhuis.dhwco.web.admin.activiteiten;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/activiteiten")
@Controller
public class AdminActiviteitenController {
    @GetMapping
    public String get() {
        return "/admin/activiteiten/index";
    }
}
