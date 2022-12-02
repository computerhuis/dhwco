package com.github.computerhuis.dhwco.web.admin.postcodes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/postcodes")
@Controller
public class AdminPostcodesController {
    @GetMapping
    public String get() {
        return "/admin/postcodes/index";
    }
}
