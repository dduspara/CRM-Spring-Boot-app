package com.dominik.crm.controller;

import com.dominik.crm.dto.ProdajaRequest;
import com.dominik.crm.dto.ProdajaResponse;
import com.dominik.crm.entity.Artikl;
import com.dominik.crm.entity.Kupac;
import com.dominik.crm.service.ProdajaService;
import com.dominik.crm.entity.Prodaja;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prodaje")
public class ProdajaController {

    private final ProdajaService prodajaService;

    public ProdajaController(ProdajaService prodajaService) {
        this.prodajaService = prodajaService;
    }

    @GetMapping
    public List<ProdajaResponse> sveProdaje() {
        return prodajaService.sveProdaje()
                .stream()
                .map(prodaja -> new ProdajaResponse(
                        prodaja.getId(),
                        prodaja.getKolicina(),
                        prodaja.getCijena(),
                        prodaja.getDatum(),
                        prodaja.getKupac().getId(),
                        prodaja.getArtikl().getId(),
                        prodaja.getArtikl().getNaziv()
                ))
                .toList();
    }

    @PostMapping
    public ProdajaResponse dodajProdaju(@RequestBody ProdajaRequest request) {
        Prodaja prodaja = new Prodaja();

        Kupac kupac = new Kupac();
        kupac.setId(request.getKupacId());

        Artikl artikl = new Artikl();
        artikl.setId(request.getArtiklId());

        prodaja.setKupac(kupac);
        prodaja.setArtikl(artikl);
        prodaja.setKolicina(request.getKolicina());
        prodaja.setDatum(request.getDatum());

        Prodaja spremljenaProdaja = prodajaService.spremi(prodaja);

        return new ProdajaResponse(
                spremljenaProdaja.getId(),
                spremljenaProdaja.getKolicina(),
                spremljenaProdaja.getCijena(),
                spremljenaProdaja.getDatum(),
                spremljenaProdaja.getKupac().getId(),
                spremljenaProdaja.getArtikl().getId(),
                spremljenaProdaja.getArtikl().getNaziv()
        );


    }

    @GetMapping("/kupac/{id}/ukupno")
    public Double ukupnoPoKupcu(
            @PathVariable Long id,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
            ) {
        return prodajaService.ukupnoPoKupcuURasponu(id, from, to);
    }




}
