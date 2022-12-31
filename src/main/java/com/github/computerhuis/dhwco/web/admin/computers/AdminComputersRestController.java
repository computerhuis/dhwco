package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.config.MessageSourceConfiguration;
import com.github.computerhuis.dhwco.exception.RestResponseStatusException;
import com.github.computerhuis.dhwco.model.Computer;
import com.github.computerhuis.dhwco.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/admin/computers")
@RestController
class AdminComputersRestController {
    private final AdminComputersRestMapper computersMapper;
    private final ComputerRepository computerRepository;

    @GetMapping
    public OverzichtComputers get() {
        return new OverzichtComputers(computersMapper.toSet(computerRepository.findAll()));
    }

    @GetMapping("/{nr}")
    public Computer getBedrijf(@PathVariable("nr") final long nr, final Model model) {
        val computer = computerRepository.findById(nr);
        if (computer.isEmpty()) {
            throw new RestResponseStatusException(HttpStatus.NOT_FOUND, MessageSourceConfiguration.getLabel("admin.computer.exception.not_found"));
        }
        return computer.get();
    }
}
