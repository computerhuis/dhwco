package com.github.computerhuis.dhwco.repository;

import com.github.computerhuis.dhwco.model.Persoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoonRepository extends JpaRepository<Persoon, Long> {
}
