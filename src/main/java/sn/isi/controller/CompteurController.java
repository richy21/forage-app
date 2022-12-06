package sn.isi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Compteur;
import sn.isi.service.CompteurService;


import javax.validation.Valid;
import java.util.List;

public class CompteurController {
    private CompteurService compteurService;

    @GetMapping
    public List<Compteur> getCompteur() {
        return compteurService.getCompteur();
    }

    @GetMapping("/{id}")
    public Compteur getCompteur(@PathVariable("id") int id) {
        return compteurService.getCompteur(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Compteur createCompteur(@Valid @RequestBody Compteur compteur) {
        return compteurService.createCompteur(compteur);
    }

    @PutMapping("/{id}")
    public Compteur updateCompteur(@PathVariable("id") int id, @Valid @RequestBody Compteur compteur) {
        return compteurService.updateCompteur(id, compteur);
    }

    @DeleteMapping("/{id}")
    public void deleteCompteur(@PathVariable("id") int id) {
        compteurService.deleteCompteur(id);
    }
}
