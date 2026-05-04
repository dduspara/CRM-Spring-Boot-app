package com.dominik.crm.dto;

import com.dominik.crm.entity.TipArtikla;

public class ArtiklResponse {
    private Long id;
    private String naziv;
    private Double cijena;
    private TipArtikla tip;

    public ArtiklResponse(Long id, String naziv, Double cijena, TipArtikla tip) {
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        this.tip = tip;
    }

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public Double getCijena() {
        return cijena;
    }

    public TipArtikla getTip() {
        return tip;
    }
}
