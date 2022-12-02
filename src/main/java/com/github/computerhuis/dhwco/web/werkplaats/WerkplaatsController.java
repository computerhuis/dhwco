package com.github.computerhuis.dhwco.web.werkplaats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/werkplaats")
@Controller
class WerkplaatsController {
    @GetMapping
    public String get() {
        return "/werkplaats/index";
    }
}
