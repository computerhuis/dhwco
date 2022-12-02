package com.github.computerhuis.dhwco.web.admin.rechten;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
class AdminRechtenController {
    @GetMapping
    public String get() {
        return "/admin/rechten/index";
    }

}
