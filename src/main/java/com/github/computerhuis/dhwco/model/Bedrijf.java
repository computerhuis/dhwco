package com.github.computerhuis.dhwco.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@DynamicUpdate
@DynamicInsert
@Data
@Entity
@Table(name = "bedrijven")
public class Bedrijf implements Serializable {

    @Serial
    private static final long serialVersionUID = -7083493614312172546L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nr;
    private String naam;
    private String email;
    private String telefoon;
    private String straat;
    private String postcode;
    private Integer huisnummer;
    private String huisnummertoevoeging;
    private String woonplaats;
    private String kvk_nummer;
    private String btw_nummer;
    private String website;
    private String opmerkingen;
    private OffsetDateTime inschrijfDatum;
    private OffsetDateTime uitschrijfDatum;
}
