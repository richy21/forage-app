package sn.isi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Facture;
import sn.isi.dto.Operation;
import sn.isi.service.FactureService;
import sn.isi.service.OperationService;

import javax.validation.Valid;
import java.util.List;

public class FactureController {

    private FactureService factureService;

    @GetMapping
    public List<Facture> getFacture() {
        return factureService.getFacture();
    }

    @GetMapping("/{id}")
    public Facture getFacture(@PathVariable("id") int id) {
        return factureService.getFacture(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Facture createFacture(@Valid @RequestBody Facture facture) {
        return factureService.createFacture(facture);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable("id") int id, @Valid @RequestBody Facture facture) {
        return factureService.updateFacture(id, facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable("id") int id) {
        factureService.deleteFacture(id);
    }
}
