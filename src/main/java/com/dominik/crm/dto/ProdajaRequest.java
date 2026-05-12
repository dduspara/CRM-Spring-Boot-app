package com.dominik.crm.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ProdajaRequest {
    @NotNull(message = "Kolicina je obavezna.")
    @Positive(message = "Kolicina mora biti veca od 0")
    private Integer kolicina;
    @NotNull(message = "Datum prodaje je obavezan.")
    private LocalDate datum;
    @NotNull(message = "ID kupca je obavezan.")
    private Long kupacId;
    @NotNull(message = "ID artikla je obavezan.")
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
