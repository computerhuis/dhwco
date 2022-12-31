package com.github.computerhuis.dhwco.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.val;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@DynamicUpdate
@DynamicInsert
@Data
@Entity
@Table(name = "personen")
public class Persoon implements Serializable {

    @Serial
    private static final long serialVersionUID = -7775857132587912855L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nr;

    private String voorletters;
    private String voornaam;
    private String tussenvoegsels;
    private String achternaam;
    private LocalDate geboortedatum;
    private String email;
    private String mobile;
    private String telefoon;
    private String postcode;
    private String straat;
    private Integer huisnummer;
    private String huisnummertoevoeging;
    private String woonplaats;
    private String opmerkingen;
    private LocalDateTime inschrijfDatum;
    private LocalDateTime uitschrijfDatum;

    public Integer getLeeftijd() {
        if (geboortedatum == null) {
            return null;
        }

        val period = Period.between(geboortedatum, LocalDate.now());
        return period.getYears();
    }
}
