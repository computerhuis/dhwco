package com.github.computerhuis.dhwco.web.admin.computers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/computers")
@Controller
class AdminComputersController {
    @GetMapping
    public String get() {
        return "/admin/computers/index";
    }
}
