package com.github.computerhuis.dhwco.web.admin.tijdregistraties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/tijdregistraties")
@Controller
public class AdminTijdregistratiesController {
    @GetMapping
    public String get() {
        return "/admin/tijdregistraties/index";
    }
}
