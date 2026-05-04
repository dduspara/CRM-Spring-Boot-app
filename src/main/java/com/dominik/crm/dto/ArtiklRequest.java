package com.dominik.crm.dto;

import com.dominik.crm.entity.TipArtikla;

public class ArtiklRequest {
    private String naziv;
    private Double cijena;
    private TipArtikla tip;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public TipArtikla getTip() {
        return tip;
    }

    public void setTip(TipArtikla tip) {
        this.tip = tip;
    }
}
