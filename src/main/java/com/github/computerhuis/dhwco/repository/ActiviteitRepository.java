package com.github.computerhuis.dhwco.repository;

import com.github.computerhuis.dhwco.model.Activiteit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteitRepository extends JpaRepository<Activiteit, Long> {
}
