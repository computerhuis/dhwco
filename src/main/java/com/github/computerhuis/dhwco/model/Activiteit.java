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
@Table(name = "activiteiten")
public class Activiteit implements Serializable {

    @Serial
    private static final long serialVersionUID = 895959306366111404L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nr;

    private String naam;
    private boolean rapportage;
    private OffsetDateTime actiefVanaf;
    private OffsetDateTime actiefTot;

}
