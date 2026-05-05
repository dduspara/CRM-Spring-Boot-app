package com.dominik.crm.dto;

import com.dominik.crm.entity.TipKupca;

public class KupacResponse {
    private Long id;
    private String ime;
    private String prezime;
    private String oib;
    private String adresa;
    private String telefon;
    private String nazivTvrtke;
    private String email;
    private String web;
    private String kontaktOsoba;
    private TipKupca tip;

    public KupacResponse(Long id, String ime, String prezime, String oib, String adresa, String telefon, String nazivTvrtke, String email, String web, String kontaktOsoba, TipKupca tip) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.adresa = adresa;
        this.telefon = telefon;
        this.nazivTvrtke = nazivTvrtke;
        this.email = email;
        this.web = web;
        this.kontaktOsoba = kontaktOsoba;
        this.tip = tip;
    }

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getOib() {
        return oib;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getNazivTvrtke() {
        return nazivTvrtke;
    }

    public String getEmail() {
        return email;
    }

    public String getWeb() {
        return web;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public TipKupca getTip() {
        return tip;
    }
}
