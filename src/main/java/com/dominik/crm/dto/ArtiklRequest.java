package com.dominik.crm.dto;

import com.dominik.crm.entity.TipArtikla;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ArtiklRequest {
    @NotBlank(message = "Naziv artikla je obavezan.")
    private String naziv;
    @NotNull(message = "Cijena je obavezna.")
    @Positive(message = "Cijena mora biti veca od 0.")
    private Double cijena;
    @NotNull(message = "Tip artikla je obavezan.")
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
