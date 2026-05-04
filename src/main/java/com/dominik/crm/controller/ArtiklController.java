package com.dominik.crm.controller;

import com.dominik.crm.dto.ArtiklRequest;
import com.dominik.crm.dto.ArtiklResponse;
import com.dominik.crm.service.ArtiklService;
import com.dominik.crm.entity.Artikl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artikli")
public class ArtiklController {
    private final ArtiklService artiklService;

    public ArtiklController(ArtiklService artiklService) {
        this.artiklService = artiklService;
    }
    @GetMapping
    public List<ArtiklResponse> sviArtikli() {
        return  artiklService.sviArtikli()
                .stream()
                .map(artikl -> new ArtiklResponse(
                        artikl.getId(),
                        artikl.getNaziv(),
                        artikl.getCijena(),
                        artikl.getTip()
                ))
                .toList();
    }
    @PostMapping
    public ArtiklResponse dodajArtikl(@RequestBody ArtiklRequest request) {
        Artikl artikl = new Artikl();

        artikl.setNaziv(request.getNaziv());
        artikl.setCijena(request.getCijena());
        artikl.setTip(request.getTip());

        Artikl spremljenArtikl = artiklService.spremi(artikl);

        return new ArtiklResponse(
                spremljenArtikl.getId(),
                spremljenArtikl.getNaziv(),
                spremljenArtikl.getCijena(),
                spremljenArtikl.getTip()
        );
    }


}
