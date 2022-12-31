package com.github.computerhuis.dhwco.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Data
@Entity
@Table(name = "computers")
public class Computer implements Serializable {

    @Serial
    private static final long serialVersionUID = -4696683544240335421L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nr;

    @Enumerated(EnumType.STRING)
    private ComputerType type;
    private String fabrikant;
    private String model;
    private String specificatie;
    private Long bedrijfNr;
    private Long persoonNr;

    private LocalDateTime inboekDatum;
    private LocalDateTime uitboekDatum;
}
