package com.dominik.crm.entity;

import jakarta.persistence.*;

@Entity
public class Artikl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private double cijena;
    @Enumerated (EnumType.STRING)
    private TipArtikla tip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public TipArtikla getTip() {
        return tip;
    }

    public void setTip(TipArtikla tip) {
        this.tip = tip;
    }
}
