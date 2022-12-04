package com.github.computerhuis.dhwco.web.admin.bedrijven;

import com.github.computerhuis.dhwco.repository.BedrijfRepository;
import com.github.computerhuis.dhwco.web.core.DataTable;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/admin/bedrijven")
@RestController
public class AdminBedrijvenRestController {
    private final BedrijfRepository bedrijfRepository;

    @GetMapping
    public DataTable get() {
        val bedrijven = bedrijfRepository.findAll();
        final List<List<String>> data = new LinkedList<>();
        for (val bedrijf : bedrijven) {
            List<String> row = new LinkedList<>();
            row.add(bedrijf.getNr().toString());
            row.add(bedrijf.getNaam());
            row.add(bedrijf.getWoonplaats());
            row.add(bedrijf.getPostcode());
            row.add(bedrijf.getInschrijfDatum().toString());
            data.add(row);
        }
        return new DataTable(data);
    }
}
