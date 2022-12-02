package com.github.computerhuis.dhwco.web.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/monitor")
@Controller
class MonitorController {
    @GetMapping
    public String get() {
        return "/monitor/index";
    }
}
