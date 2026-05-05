package com.dominik.crm.controller;

import com.dominik.crm.dto.KupacRequest;
import com.dominik.crm.dto.KupacResponse;
import com.dominik.crm.service.KupacService;
import com.dominik.crm.service.ProdajaService;
import com.dominik.crm.entity.Kupac;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kupci")
public class KupacController {
    private final KupacService kupacService;
    private final ProdajaService prodajaService;
    public KupacController (KupacService kupacService, ProdajaService prodajaService) {
        this.kupacService = kupacService;
        this.prodajaService = prodajaService;
    }
    @GetMapping
    public List<KupacResponse> sviKupci() {

        return kupacService.sviKupci()
                .stream()
                .map(kupac -> new KupacResponse(
                        kupac.getId(),
                        kupac.getIme(),
                        kupac.getPrezime(),
                        kupac.getOib(),
                        kupac.getAdresa(),
                        kupac.getTelefon(),
                        kupac.getNazivTvrtke(),
                        kupac.getEmail(),
                        kupac.getWeb(),
                        kupac.getKontaktOsoba(),
                        kupac.getTip()

                ))
                .toList();
    }

    @PostMapping
    public KupacResponse dodajKupca (@RequestBody KupacRequest request) {
        Kupac kupac = new Kupac();
        kupac.setIme(request.getIme());
        kupac.setPrezime(request.getPrezime());
        kupac.setOib(request.getOib());
        kupac.setAdresa(request.getAdresa());
        kupac.setTelefon(request.getTelefon());
        kupac.setNazivTvrtke(request.getNazivTvrtke());
        kupac.setEmail(request.getEmail());
        kupac.setWeb(request.getWeb());
        kupac.setKontaktOsoba(request.getKontaktOsoba());
        kupac.setTip(request.getTip());


        Kupac spremljenKupac = kupacService.spremiKupca(kupac);
        return new KupacResponse(
                spremljenKupac.getId(),
                spremljenKupac.getIme(),
                spremljenKupac.getPrezime(),
                spremljenKupac.getOib(),
                spremljenKupac.getAdresa(),
                spremljenKupac.getTelefon(),
                spremljenKupac.getNazivTvrtke(),
                spremljenKupac.getEmail(),
                spremljenKupac.getWeb(),
                spremljenKupac.getKontaktOsoba(),
                spremljenKupac.getTip()
        );
    }

    @GetMapping("/{id}/ukupna-prodaja")
    public Double ukupnaProdaja (@PathVariable Long id) {
        return prodajaService.ukupnoPoKupcu(id);
    }
}
