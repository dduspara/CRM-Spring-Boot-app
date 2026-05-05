package com.dominik.crm.dto;

import java.time.LocalDate;

public class ProdajaRequest {
    private Integer kolicina;
    private LocalDate datum;
    private Long kupacId;
    private Long artiklId;

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Long getKupacId() {
        return kupacId;
    }

    public void setKupacId(Long kupacId) {
        this.kupacId = kupacId;
    }

    public Long getArtiklId() {
        return artiklId;
    }

    public void setArtiklId(Long artiklId) {
        this.artiklId = artiklId;
    }
}
