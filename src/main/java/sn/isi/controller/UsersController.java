package sn.isi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Users;
import sn.isi.service.UsersService;

import javax.validation.Valid;
import java.util.List;

public class UsersController {
    private UsersService usersService;

    @GetMapping
    public List<Users> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/{id}")
    public Users getUsers(@PathVariable("id") int id) {
        return usersService.getUsers(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Users createUsers(@Valid @RequestBody Users users) {
        return usersService.createUsers(users);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@PathVariable("id") int id, @Valid @RequestBody Users users) {
        return usersService.updateUsers(id, users);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable("id") int id) {
        usersService.deleteUsers(id);
    }
}
