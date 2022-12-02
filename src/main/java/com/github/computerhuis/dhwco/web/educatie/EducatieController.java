package com.github.computerhuis.dhwco.web.educatie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/educatie")
@Controller
class EducatieController {
    @GetMapping
    public String get() {
        return "/educatie/index";
    }
}
