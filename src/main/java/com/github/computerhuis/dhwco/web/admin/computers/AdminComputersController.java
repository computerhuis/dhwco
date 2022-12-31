package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin/computers")
@Controller
class AdminComputersController {

    private final ComputerRepository computerRepository;

    @GetMapping
    public String get() {
        return "/admin/computers/index";
    }

    @GetMapping("/{nr}")
    public String getBedrijf(@PathVariable("nr") final long nr, final Model model) {
        model.addAttribute("computer", computerRepository.findById(nr));
        return "/admin/computers/computer";
    }
}
