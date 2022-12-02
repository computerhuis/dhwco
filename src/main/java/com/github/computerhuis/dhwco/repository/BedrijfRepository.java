package com.github.computerhuis.dhwco.repository;

import com.github.computerhuis.dhwco.model.Bedrijf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedrijfRepository extends JpaRepository<Bedrijf, Long> {
}
