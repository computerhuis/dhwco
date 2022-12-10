package com.github.computerhuis.dhwco.repository;

import com.github.computerhuis.dhwco.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
