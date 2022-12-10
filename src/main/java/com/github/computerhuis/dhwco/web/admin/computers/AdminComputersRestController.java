package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

}
