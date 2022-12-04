package com.github.computerhuis.dhwco.web.admin.computers;

import com.github.computerhuis.dhwco.repository.PersoonRepository;
import com.github.computerhuis.dhwco.web.core.DataTable;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/admin/personen")
@RestController
public class AdminPersonenRestController {
    private final PersoonRepository persoonRepository;

    @GetMapping
    public DataTable get() {
        val personen = persoonRepository.findAll();
        final List<List<String>> data = new LinkedList<>();
        for (val persoon : personen) {
            List<String> row = new LinkedList<>();
            row.add(persoon.getNr().toString());

            data.add(row);
        }
        return new DataTable(data);
    }
}
