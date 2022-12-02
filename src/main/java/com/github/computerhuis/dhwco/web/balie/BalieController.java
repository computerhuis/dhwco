package com.github.computerhuis.dhwco.web.balie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/balie")
@Controller
class BalieController {
    @GetMapping
    public String get() {
        return "/balie/index";
    }
}
