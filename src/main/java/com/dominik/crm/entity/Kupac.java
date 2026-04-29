package com.dominik.crm.entity;

import jakarta.persistence.*;


@Entity
public class Kupac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // zajednicki podaci
    private String oib;
    private String adresa;
    private String email;
    private String telefon;

    // poslovni kupac
    private String nazivTvrtke;
    private String web;
    private String kontaktOsoba;

    // privatni kupac
    private String ime;
    private String prezime;

    // tip kupca
    @Enumerated(EnumType.STRING)
    private TipKupca tip;

    // getteri i setteri


    public Long getId() {
        return id;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNazivTvrtke() {
        return nazivTvrtke;
    }

    public void setNazivTvrtke(String nazivTvrtke) {
        this.nazivTvrtke = nazivTvrtke;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public TipKupca getTip() {
        return tip;
    }

    public void setTip(TipKupca tip) {
        this.tip = tip;
    }
}
