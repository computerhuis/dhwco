package com.github.computerhuis.dhwco.web.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
class DashboardController {
    @GetMapping
    public String get() {
        return "/dashboard/index";
    }
}
