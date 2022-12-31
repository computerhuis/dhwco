package com.github.computerhuis.dhwco.web.admin.computers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin/computers")
@Controller
class AdminComputersController {

    @GetMapping
    public String get() {
        return "/admin/computers/index";
    }

    @GetMapping("/{nr}")
    public String getBedrijf(@PathVariable("nr") final long nr) {
        return "/admin/computers/computer";
    }
}
