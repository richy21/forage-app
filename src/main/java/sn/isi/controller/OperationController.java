package sn.isi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Operation;
import sn.isi.service.OperationService;

import javax.validation.Valid;
import java.util.List;

public class OperationController {

    private OperationService operationService;

    @GetMapping
    public List<Operation> getOperation() {
        return operationService.getOperation();
    }

    @GetMapping("/{id}")
    public Operation getOperation(@PathVariable("id") int id) {
        return operationService.getOperation(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Operation createOperation(@Valid @RequestBody Operation operation) {
        return operationService.createOperation(operation);
    }

    @PutMapping("/{id}")
    public Operation updateOperation(@PathVariable("id") int id, @Valid @RequestBody Operation operation) {
        return operationService.updateOperation(id, operation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable("id") int id) {
        operationService.deleteOperation(id);
    }
}
