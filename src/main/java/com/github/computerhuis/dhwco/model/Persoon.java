package com.github.computerhuis.dhwco.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

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
}
