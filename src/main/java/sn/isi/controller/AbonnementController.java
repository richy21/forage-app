package sn.isi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Abonnement;
import sn.isi.service.AbonnementService;

import javax.validation.Valid;
import java.util.List;

public class AbonnementController {

    private AbonnementService abonnementService;

    @GetMapping
    public List<Abonnement> getAbonnement() {
        return abonnementService.getAbonnement();
    }

    @GetMapping("/{id}")
    public Abonnement getAbonnement(@PathVariable("id") int id) {
        return abonnementService.getAbonnement(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Abonnement createAbonnement(@Valid @RequestBody Abonnement abonnement) {
        return abonnementService.createAbonnement(abonnement);
    }

    @PutMapping("/{id}")
    public Abonnement updateAbonnement(@PathVariable("id") int id, @Valid @RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(id, abonnement);
    }

    @DeleteMapping("/{id}")
    public void deleteAbonnement(@PathVariable("id") int id) {
        abonnementService.deleteAbonnement(id);
    }
}
