package sn.isi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Roles;
import sn.isi.dto.Village;
import sn.isi.service.RolesServices;

import javax.validation.Valid;
import java.util.List;

public class RolesController {

    private RolesServices rolesService;

    @GetMapping
    public List<Roles> getRoles() {
        return rolesService.getRoles();
    }

    @GetMapping("/{id}")
    public Roles getRoles(@PathVariable("id") int id) {
        return rolesService.getRoles(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Roles createRoles(@Valid @RequestBody Roles roles) {
        return rolesService.createRoles(roles);
    }

    @PutMapping("/{id}")
    public Roles updateRoles(@PathVariable("id") int id, @Valid @RequestBody Roles roles) {
        return rolesService.updateRoles(id, roles);
    }

    @DeleteMapping("/{id}")
    public void deleteRoles(@PathVariable("id") int id) {
        rolesService.deleteRoles(id);
    }
}
