package com.dominik.crm.dto;

import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDate;

public class ProdajaResponse {
    private long id;
    private Integer kolicina;
    private double cijena;
    private LocalDate datum;

    private Long kupacId;
    private Long artiklId;
    private String nazivArtikla;

    public ProdajaResponse(long id, Integer kolicina, double cijena, LocalDate datum, Long kupacId, Long artiklId, String nazivArtikla) {
        this.id = id;
        this.kolicina = kolicina;
        this.cijena = cijena;
        this.datum = datum;
        this.kupacId = kupacId;
        this.artiklId = artiklId;
        this.nazivArtikla = nazivArtikla;
    }

    public long getId() {
        return id;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public double getCijena() {
        return cijena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Long getKupacId() {
        return kupacId;
    }

    public Long getArtiklId() {
        return artiklId;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }
}
