package com.github.computerhuis.dhwco.web.admin.activiteiten;

import com.github.computerhuis.dhwco.model.Activiteit;
import com.github.computerhuis.dhwco.repository.ActiviteitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/admin/activiteiten")
@RestController
public class AdminActiviteitenRestController {

    private final ActiviteitRepository activiteitRepository;

    @GetMapping
    public List<Activiteit> get() {
        return activiteitRepository.findAll();
    }
}
